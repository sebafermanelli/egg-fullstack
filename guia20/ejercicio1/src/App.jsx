import { useState } from 'react';
import './App.css';
import { Ejemplo } from './components/Ejemplo';

function App() {
	const [count, setCount] = useState(0);

	return (
		<>
			<Ejemplo title="Titulo" subtitle="Subtitulo" />
		</>
	);
}

export default App;
