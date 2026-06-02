import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../services/api';

const getApiErrorMessage = (err, fallback) => {
  const data = err.response?.data;

  if (typeof data === 'string') {
    return data;
  }

  return data?.message || data?.error || fallback;
};

function Dashboard() {
  const navigate = useNavigate();
  const [notes, setNotes] = useState([]);
  const [formData, setFormData] = useState({
    title: '',
    content: '',
  });
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(true);
  const [saving, setSaving] = useState(false);
  const contentWords = formData.content.trim()
    ? formData.content.trim().split(/\s+/).length
    : 0;
  const contentCharacters = formData.content.length;

  const fetchNotes = async () => {
    setError('');
    setLoading(true);

    try {
      const response = await api.get('/notes');
      setNotes(response.data);
    } catch (err) {
      setError(getApiErrorMessage(err, 'Unable to fetch notes.'));
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchNotes();
  }, []);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormData((current) => ({
      ...current,
      [name]: value,
    }));
  };

  const handleCreateNote = async (event) => {
    event.preventDefault();
    setError('');
    setSaving(true);

    try {
      const response = await api.post('/notes', formData);
      setNotes((current) => [response.data, ...current]);
      setFormData({ title: '', content: '' });
    } catch (err) {
      setError(getApiErrorMessage(err, 'Unable to create note.'));
    } finally {
      setSaving(false);
    }
  };

  const handleDeleteNote = async (id) => {
    setError('');

    try {
      await api.delete(`/notes/${id}`);
      setNotes((current) => current.filter((note) => note.id !== id));
    } catch (err) {
      setError(getApiErrorMessage(err, 'Unable to delete note.'));
    }
  };

  const handleLogout = () => {
    localStorage.removeItem('token');
    navigate('/login');
  };

  return (
    <main className="dashboard-page">
      <header className="dashboard-header">
        <div>
          <h1>StudyBuddy Dashboard</h1>
          <p className="muted">Create, review, and remove your notes.</p>
        </div>
        <button type="button" className="secondary-button" onClick={handleLogout}>
          Logout
        </button>
      </header>

      <section className="dashboard-grid">
        <form onSubmit={handleCreateNote} className="note-form">
          <h2>Create Note</h2>

          <label htmlFor="title">Title</label>
          <input
            id="title"
            name="title"
            type="text"
            value={formData.title}
            onChange={handleChange}
            required
          />

          <div className="content-label-row">
            <label htmlFor="content">Content</label>
            <span className="content-badge">Long notes supported</span>
          </div>
          <textarea
            id="content"
            name="content"
            value={formData.content}
            onChange={handleChange}
            rows="12"
            placeholder="Paste your full study material, summaries, or long notes here..."
            required
          />
          <div className="content-stats">
            <span>{contentWords} words</span>
            <span>{contentCharacters} characters</span>
          </div>

          {error && <div className="alert alert-error">{error}</div>}

          <button type="submit" disabled={saving}>
            {saving ? 'Saving...' : 'Add Note'}
          </button>
        </form>

        <section className="notes-section">
          <h2>Your Notes</h2>

          {loading ? (
            <p className="muted">Loading notes...</p>
          ) : notes.length === 0 ? (
            <div className="empty-state">No notes yet. Create your first note.</div>
          ) : (
            <div className="notes-list">
              {notes.map((note) => (
                <article className="note-card" key={note.id}>
                  <div>
                    <h3>{note.title}</h3>
                    <p>{note.content}</p>
                    <div className="note-meta">
                      {note.content?.trim() ? note.content.trim().split(/\s+/).length : 0} words
                    </div>
                  </div>
                  <button
                    type="button"
                    className="danger-button"
                    onClick={() => handleDeleteNote(note.id)}
                  >
                    Delete
                  </button>
                </article>
              ))}
            </div>
          )}
        </section>
      </section>
    </main>
  );
}

export default Dashboard;
