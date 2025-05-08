package ua.com.kisit.courseonlinecourse3712025.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.com.kisit.courseonlinecourse3712025.entity.Clients;
import ua.com.kisit.courseonlinecourse3712025.repository.ClientsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements UserDetailsService {

    private final ClientsRepository clientsRepository;

    public ClientService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public Clients saveNewClient(Clients client) {
        return clientsRepository.save(client);
    }

    public boolean getClientByLogin(String username) {
        return !clientsRepository.findAllByUsername(username).isEmpty();
    }

    public boolean getClientByLoginAndPassword(String username, String password) {
        return !clientsRepository.findAllByUsernameAndPassword(username, password).isEmpty();
    }

    public Clients getClientByUsername(String username) {
        return clientsRepository.getClientByUsername(username);
    }

    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    public void updateClient(Clients client) {
        clientsRepository.save(client);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Clients client = getClientByUsername(username);

        if (client == null) {
            throw new UsernameNotFoundException(username + " not found");
        }

        return client;
    }
}
