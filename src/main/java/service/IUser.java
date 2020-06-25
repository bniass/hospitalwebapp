package service;

import model.Utilisateur;

import javax.ejb.Local;

@Local
public interface IUser {
    public Utilisateur authentification(String login, String pwd);
}
