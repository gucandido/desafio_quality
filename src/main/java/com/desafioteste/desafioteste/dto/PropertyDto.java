package com.desafioteste.desafioteste.dto;

import com.desafioteste.desafioteste.entity.Property;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PropertyDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @NotNull(message = "O nome da propriedade não pode estar vazio.")
    @NotEmpty(message = "O nome da propriedade não pode estar vazio.")
    @NotBlank(message = "O nome da propriedade não pode estar em branco")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres")
    @Pattern(regexp = "^[A-Z]\\w+", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String prop_name;

    @NotNull
    private long district_id;

    @Valid
    private List<RoomDto> rooms = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BigDecimal prop_value;

    public PropertyDto() {
    }

    public PropertyDto(Property prop) {
        this.prop_name = prop.getProp_name();
        this.district_id = prop.getDistrict_id();

        prop.getRooms().forEach(x->this.rooms.add(RoomDto.classToDto(x)));

        this.prop_value = prop.getProp_value();

    }

    public PropertyDto(String prop_name, long district_id, List<RoomDto> rooms) {
        this.prop_name = prop_name;
        this.district_id = district_id;
        this.rooms = rooms;
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public long getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(long district_id) {
        this.district_id = district_id;
    }

    public List<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }

    public BigDecimal getProp_value() {
        return prop_value;
    }

    public void setProp_value(BigDecimal prop_value) {
        this.prop_value = prop_value;
    }

    public static Property dtoToClass(PropertyDto dto){
        return new Property(dto);
    }

    public static PropertyDto classToDto(Property prop){
        return new PropertyDto(prop);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
