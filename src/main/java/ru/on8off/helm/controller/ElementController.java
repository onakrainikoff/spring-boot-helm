package ru.on8off.helm.controller;

import ru.on8off.helm.controller.dto.ElementDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.on8off.helm.service.ElementService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class ElementController {
    @Autowired
    private ElementService elementService;

    @GetMapping
    public List<ElementDto> all(){
        log.info("Request GET /");
        var result = elementService.getAll().stream().map(ElementDto::toDto).collect(Collectors.toList());
        log.info("Response: " + result);
        return result;
    }

    @GetMapping("/{id}")
    public ElementDto get(@PathVariable  Integer id){
        log.info("Request GET /{}", id);
        var result = ElementDto.toDto(elementService.get(id));
        log.info("Response: " + result);
        return result;
    }


    @PostMapping
    public ElementDto post(@RequestBody ElementDto elementDto){
        log.info("Request POST / elementDto={}", elementDto);
        var result = ElementDto.toDto(elementService.save(ElementDto.fromDto(elementDto)));
        log.info("Response: " + result);
        return result;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        log.info("Request DELETE /{}", id);
        elementService.delete(id);
        log.info("Response: OK");
    }

}
