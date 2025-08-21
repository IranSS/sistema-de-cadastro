import { useEffect, useState } from 'react'
import axios from 'axios'
import './App.css'

function App() {
  const [data, setData] = useState([])

  useEffect(() => {
    axios.get('http://localhost:8080/user/get')
    .then(response => {
      console.log(response.data)
      setData(response.data)
    })
    .catch(error => {
      console.error("erro ao requisitar get: ", error)
    })
  }, [])

  return (
    <>
      <p>{data.map(item => item.nome).join(', ')}</p>
    </>
  )
}

export default App
