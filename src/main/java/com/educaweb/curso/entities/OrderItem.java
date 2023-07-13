package com.educaweb.curso.entities;

import java.io.Serializable;
import java.util.Objects;

import com.educaweb.curso.entities.pk.OrderItemPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orderitem_tb")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private OrderItemPk id;
	
	private Integer quant;
	private Double price;
	
	public OrderItem() {}
	
	public OrderItem(Order order,Product product ,Integer quant, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quant = quant;
		this.price = price;
		
	}

	public Integer getQuant() {
		return quant;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order){
		
		id.setOrder(order);
	}
	
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product){
		
		id.setProduct(product);
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
