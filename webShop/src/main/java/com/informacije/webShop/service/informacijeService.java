package com.informacije.webShop.service;

import com.informacije.webShop.domain.informacije;
import com.informacije.webShop.repository.informacijeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class informacijeService {
    @Autowired
    private informacijeRepository repo;


    public void saveInformacije(informacije i,MultipartFile file) throws IOException {
        i.setSlika(Base64.getEncoder().encodeToString(file.getBytes()));
        repo.save(i);
    }


    public List<informacije> listAll(){
        return repo.findAll();
    }

    public void save(informacije i){
        repo.save(i);
    }
    public informacije get(long ID){
        return repo.findById(ID).get();

    }

    public void delete(long ID){
        repo.deleteById(ID);
    }
}
