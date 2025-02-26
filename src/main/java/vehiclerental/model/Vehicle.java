package vehiclerental.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(nullable = false)
	    private String model;

	    @Column(nullable = false)
	    private String brand;

	    @Column(nullable = false)
	    private double pricePerDay;

	    @Column(nullable = false)
	    private Boolean available;

	    public Vehicle() {}

	    public Vehicle(String model, String brand, double pricePerDay, boolean available) {
	        this.model = model;
	        this.brand = brand;
	        this.pricePerDay = pricePerDay;
	        this.available = available;
	    }

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public double getPricePerDay() {
			return pricePerDay;
		}

		public void setPricePerDay(double pricePerDay) {
			this.pricePerDay = pricePerDay;
		}

		public Boolean isAvailable() {
			return available;
		}

		public void setAvailable(Boolean available) {
			this.available = available;
		}
		@Override
	    public String toString() {
	        return "Vehicle{" +
	                "id=" + id +
	                ", model='" + model + '\'' +
	                ", brand='" + brand + '\'' +
	                ", pricePerDay=" + pricePerDay +
	                ", available=" + available +
	                '}';

	    
}
}



