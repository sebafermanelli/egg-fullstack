package service;

import dao.EditorialDAO;

public class EditorialService {
    private EditorialDAO editorialDAO;

    public EditorialService(EditorialDAO editorialDAO) {
        this.editorialDAO = editorialDAO;
    }
}
