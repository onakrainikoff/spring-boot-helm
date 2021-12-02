package ru.on8off.helm.controller.dto;

import ru.on8off.helm.repository.entity.Element;
import lombok.Data;

@Data
public class ElementDto {
    private Integer id;
    private String name;

    public static ElementDto toDto(Element element){
        if(element == null) {
            return null;
        }
        var elementDto = new ElementDto();
        elementDto.setId(element.getId());
        elementDto.setName(element.getName());
        return elementDto;
    }

    public static Element fromDto(ElementDto elementDto){
        var element = new Element();
        element.setId(elementDto.getId());
        element.setName(elementDto.getName());
        return element;
    }
}
