import { useState } from 'react';

export const Contador = (props) => {
	const [count, setCount] = useState(0);
	const [nombre, setNombre] = useState();

	return (
		<div>
			<p>Contador: {count}</p>
			<button onClick={() => setCount(count + 1)}>Sumar</button>
			<br />
			<br />
			<label htmlFor="">Ingrese nombre </label>
			<input type="text" onChange={(e) => setNombre(e.target.value)} />
			<p>Su nombre: {nombre}</p>
		</div>
	);
};
