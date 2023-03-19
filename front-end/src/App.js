import axios from 'axios';
import { useState, useEffect } from 'react';
import api from './api/axiosConfig';
import './App.css';

function App() {

  //movies state for storing movies
  const [movies, setMovies] = useState();

  //get all movies in database from api: "/api/v1/movies"
  const getMovies = async() => {
    try{
      const response = await axios.get("http://localhost:8080/api/movies/");
      console.log(response.data);
      setMovies(response.data);
    }
    catch(error){
      console.log(error);
    }
  }

  useEffect(()=>{
    getMovies();
  },[]);

  return (
    <div className="App">
      
    </div>
  );
}

export default App;
