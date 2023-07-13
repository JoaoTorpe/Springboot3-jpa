package com.educaweb.curso.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.educaweb.curso.entities.Order;
import com.educaweb.curso.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order Order;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product Product;
	
	
	
	
	public Order getOrder() {
		return Order;
	}
	public void setOrder(Order order) {
		Order = order;
	}
	public Product getProduct() {
		return Product;
	}
	public void setProduct(Product product) {
		Product = product;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Order, Product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPk other = (OrderItemPk) obj;
		return Objects.equals(Order, other.Order) && Objects.equals(Product, other.Product);
	}

}
