package com.rodrigo.barbosa.curso.springboot.entidades.enums;

public enum StatusPedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private StatusPedido(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static StatusPedido valorDe(int codigo) {
		for (StatusPedido valor : StatusPedido.values()) {
			if (valor.getCodigo() == codigo) {
				return valor;
			}
		}
		
		throw new IllegalArgumentException("Codigo de status de pedido invalido");
	}
}
