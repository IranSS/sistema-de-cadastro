import { useEffect, useState } from 'react'
import axios from 'axios'
import './App.css'

function App() {
  const [nome, setNome] = useState('');
  const [data, setData] = useState([]);

  const url = import.meta.env.VITE_API_URL;

  useEffect(() => {
    axios.get(`${url}/user/get`)
      .then(response => {
        console.log(response.data);
        setData(response.data);
      })
      .catch(error => {
        console.error("erro ao requisitar get: ", error);
      })
  }, [])
  const handleSubmit = (event) => {
    try {
      axios.post(`${url}/user/post`, {
        nome,
      });
      setNome('');
    } catch (error) {
      alert("erro: ", error, " event: ", event);
      console.log("Erro ao enviar dados: ", error);
    }
  }

  const handleReload = () => {
    window.location.reload()
  }

  return (
    <>
      <h2>Seja bem vindo ao teste</h2>
      <div>
        <input
          type="text"
          placeholder="Digite o Nome"
          value={nome}
          onChange={e => setNome(e.target.value)} />
        <br />
        <button onClick={handleSubmit}>Enviar</button>
      </div>
      <button onClick={handleReload}>Recarregar</button>
      <p>{data.map(item => item.nome).join(', ')}</p>
    </>
  )
}

export default App
