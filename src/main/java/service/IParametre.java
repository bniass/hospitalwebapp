package service;

import model.Service;
import model.Specialite;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IParametre {
    public List<Specialite> findSpecialites();
    public List<Service> findServices();
}
