import { useState, useEffect } from 'react';
import CharactersService from '../services/Characters.service';
import { Character } from './Character';

export const Characters = (props) => {
	const [chars, setChars] = useState([]);

	useEffect(() => {
		CharactersService.getAllCharacters()
			.then((data) => {
				setChars(data.results);
			})
			.catch((err) => {
				console.log(err);
			});
	}, []);

	const charactersList = chars.map((c) => {
		return <Character char={c} key={c.id} />;
	});

	return (
		<div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-2">
			{charactersList}
		</div>
	);
};
