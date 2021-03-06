package com.desafioteste.desafioteste.entity;

import com.desafioteste.desafioteste.dto.PropertyDto;
import com.desafioteste.desafioteste.dto.RoomDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Property {

    private long id;
    private String prop_name;
    private long district_id;
    private List<Room> rooms = new ArrayList<>();
    private BigDecimal prop_value;

    public Property(PropertyDto dto) {
        this.prop_name = dto.getProp_name();
        this.district_id = dto.getDistrict_id();

        dto.getRooms().forEach(x->this.rooms.add(RoomDto.dtoToClass(x)));
    }

    public BigDecimal getProp_value() {
        return prop_value;
    }

    public void setProp_value(BigDecimal prop_value) {
        this.prop_value = prop_value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public double calcTotalArea(){
        return this.rooms.stream().mapToDouble(Room::calcArea).sum();
    }

    public Room getBiggestRoom(){
        return this.rooms.stream().reduce(((room, room2) -> room.calcArea() > room2.calcArea()? room:room2)).orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return district_id == property.district_id && Objects.equals(prop_name, property.prop_name) && Objects.equals(rooms, property.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prop_name, district_id, rooms);
    }
}
