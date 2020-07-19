package com.test.datacollector.models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataCollectorRequest {
//    @XmlElement(name = "uri")
    private String uri;

//    @XmlElement(name = "name")
    private String name;

//    @XmlElement(name = "id")
    private String id;

//    @XmlAttribute(name = "location")
    private DeviceLocation location;

//    @XmlElement(name = "purpose")
    private String purpose;

//    @XmlElement(name = "owner")
    private String owner;

//    @XmlAttribute(name = "keywords")
    private List<String> keywords;

//    @XmlAttribute(name = "services")
    private List<Service> services;

//    @XmlAttribute(name = "model")
    private DeviceModel model;

//    @XmlAttribute(name = "information")
    private DeviceInformation information;
}
