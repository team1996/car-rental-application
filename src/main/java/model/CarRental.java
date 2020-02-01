package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "car_rental")
public class CarRental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "data_form")
    private Date dateForm;

    @Column(name = "date_to")
    private Date dateTo;

    @Column(name = "status")
    private String status;

    @Column(name = "charge")
    private double charge;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id")
    private User user;

    public CarRental(Date dateForm, Date dateTo, String status, double charge, Car car, User user) {
        this.dateForm = dateForm;
        this.dateTo = dateTo;
        this.status = status;
        this.charge = charge;
        this.car = car;
        this.user = user;
    }

    public CarRental() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateForm() {
        return dateForm;
    }

    public void setDateForm(Date dateForm) {
        this.dateForm = dateForm;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public static final class CarRentalBuilder {
        private long id;
        private Date dateForm;
        private Date dateTo;
        private String status;
        private double charge;
        private Car car;
        private User user;

        private CarRentalBuilder() {
        }

        public static CarRentalBuilder aCarRental() {
            return new CarRentalBuilder();
        }

        public CarRentalBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public CarRentalBuilder withDateForm(Date dateForm) {
            this.dateForm = dateForm;
            return this;
        }

        public CarRentalBuilder withDateTo(Date dateTo) {
            this.dateTo = dateTo;
            return this;
        }

        public CarRentalBuilder withStatus(String status) {
            this.status = status;
            return this;
        }

        public CarRentalBuilder withCharge(double charge) {
            this.charge = charge;
            return this;
        }

        public CarRentalBuilder withCar(Car car) {
            this.car = car;
            return this;
        }

        public CarRentalBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public CarRental build() {
            CarRental carRental = new CarRental(dateForm, dateTo, status, charge, car, user);
            carRental.setId(id);
            return carRental;
        }
    }
}
