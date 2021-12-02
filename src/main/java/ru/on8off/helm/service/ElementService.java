package ru.on8off.helm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.on8off.helm.repository.ElementRepository;
import ru.on8off.helm.repository.entity.Element;
import java.util.List;

@Service
public class ElementService {
    @Autowired
    private ElementRepository elementRepository;

    @Transactional(readOnly = true)
    public List<Element> getAll(){
        return elementRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Element get(Integer id){
        return elementRepository.getById(id);
    }

    @Transactional
    public Element save(Element element){
        return elementRepository.save(element);
    }

    @Transactional
    public void delete(Integer id){
        elementRepository.deleteById(id);
    }
}
