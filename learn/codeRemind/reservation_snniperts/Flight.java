package org.acme.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Flights")
public class Flight {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    @Column(name = "FlightNo", length = 20)
    private String flightNo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "airlineId")
    private Airline airline = new Airline();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "depAirportId")
    private Airport departureAirport = new Airport();

    @Column(name = "depTime")
    private LocalDateTime departureTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "arrAirportId")
    private Airport arrivalAirport = new Airport();

    @Column(name = "arrTime")
    private LocalDateTime arrivalTime;

    @Column(name = "aircraftCapacity")
    private Integer aircraftCapacity;

    @Column(name = "aircraftType", length = 20)
    private String aircraftType;

    @Column(name = "TicketPrice")
    private Long ticketPrice;

    @Column(name = "availableSeats")
    private Integer availableSeats = 0;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.REMOVE)
    private List<Ticket> ticketList = new ArrayList<>();

    public Flight() {
    }

    public Flight(String flightNo, Airline airline, Airport departureAirport, String departureTime, Airport arrivalAirport, String arrivalTime, Integer aircraftCapacity, String aircraftType, Long ticketPrice) {
        this.flightNo = flightNo;
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.departureTime = LocalDateTime.parse(departureTime, DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        this.arrivalAirport = arrivalAirport;
        this.arrivalTime =  LocalDateTime.parse(arrivalTime, DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        this.aircraftCapacity = aircraftCapacity;
        this.aircraftType = aircraftType;
        this.ticketPrice = ticketPrice;
        this.availableSeats = aircraftCapacity;
        this.ticketList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        if (flightNo.length() < 2)
            throw new RuntimeException("The Flight Number is less than 2 characters.");
        else
            if (validateFlightNo(flightNo))
                this.flightNo = flightNo;
            else
                throw new RuntimeException("The Flight Number does not match the Airline Code.");
    }

    private boolean validateFlightNo(String flightNo) {
        if (this.airline.getU2digitCode() == null) return true;
        return this.airline.getU2digitCode().matches(flightNo.substring(0, 2));
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        if (airline == null) return;
        if (validateAirline(airline))
            this.airline = airline;
        else
            throw new RuntimeException("The Airline does not match the Flight Number.");
    }

    private boolean validateAirline(Airline airline) {
        if (this.flightNo == null) return true;
        return airline.getU2digitCode().matches(this.flightNo.substring(0, 2));
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        if (this.departureAirport.equals(departureAirport)) return;
        if (validateAirport(departureAirport))
            this.departureAirport = departureAirport;
        else
            throw new RuntimeException("The Airport is similar to the Arrival Airport.");
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        if (arrivalAirport == null) return;
        if (this.arrivalAirport.equals(arrivalAirport)) return;
        if (validateAirport(arrivalAirport))
            this.arrivalAirport = arrivalAirport;
        else
            throw new RuntimeException("The Airport is similar to the Departure Airport.");
    }

    private boolean validateAirport(Airport airport) {
        return !this.departureAirport.equals(airport) && !this.arrivalAirport.equals(airport);
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getAircraftCapacity() {
        return aircraftCapacity;
    }

    public void setAircraftCapacity(Integer aircraftCapacity) {
        if (aircraftCapacity < this.ticketList.size())
            throw new RuntimeException("The Capacity of the Aircraft is less than the Tickets sold.");
        this.aircraftCapacity = aircraftCapacity;
        calculateAvailableSeats();
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public Long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    private void calculateAvailableSeats() {
        Integer soldTickets = this.ticketList.size();
        if (this.availableSeats > 0)
            this.availableSeats = this.aircraftCapacity - soldTickets;
    }

    public List<Ticket> getTicketList() {
        return new ArrayList<>(ticketList);
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public void addTicket(Ticket ticket) {
        if (ticket == null) return;
        if (this.availableSeats == 0)
            throw new RuntimeException("There are no more seats available.");
        if (ticketList.contains(ticket))
            throw new RuntimeException("This Ticket is already on the list.");
        ticketList.add(ticket);
        calculateAvailableSeats();
    }

    public void removeTicket(Ticket ticket) {
        if (ticket == null) return;
        if (ticketList.contains(ticket)) {
            ticketList.remove(ticket);
            calculateAvailableSeats();
        } else
            throw new RuntimeException("This Ticket is not on the list.");
    }

    public double flightCompletness(){
        return 100*(1-(double)this.getAvailableSeats()/this.getAircraftCapacity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightNo, flight.flightNo) && Objects.equals(departureAirport, flight.departureAirport) && Objects.equals(arrivalAirport, flight.arrivalAirport) && Objects.equals(aircraftCapacity, flight.aircraftCapacity) && Objects.equals(aircraftType, flight.aircraftType) && Objects.equals(ticketPrice, flight.ticketPrice);
    }

}
