package com.lti.prc.shapper_stack.entity;

import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "cart_info")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private int numberOfPrducts;
	private double totalPrice;
	@CreationTimestamp
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime creationDateTime;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
	private List<Product> products;

}
