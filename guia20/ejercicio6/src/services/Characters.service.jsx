import { API_RM } from '../api/api';

class CharactersService {
	async getAllCharacters() {
		const response = await fetch(API_RM.CHARACTERS());
		return response.json();
	}

	async getCharacter(id) {
		const response = await fetch(API_RM.CHARACTER_BY_ID(id));
		return response.json();
	}
}

export default new CharactersService();
