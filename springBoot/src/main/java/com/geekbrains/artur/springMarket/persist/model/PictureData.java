package com.geekbrains.artur.springMarket.persist.model;


import javax.persistence.*;

@Entity
@Table(name = "pictures_data")
public class PictureData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "data", nullable = false, columnDefinition = "MEDIUMLOB")
    private byte[]data;

    public PictureData(byte[] bytes){
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public byte[] getData() { return data; }

    public void setData(byte[] data) { this.data = data; }
}
