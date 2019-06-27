package br.ufc.web.model;

public class ModelPedido {
	private ModelPrato mPrato;
	private int quantidade;
	/**
	 * @return the mPrato
	 */
	public ModelPrato getmPrato() {
		return mPrato;
	}
	/**
	 * @param mPrato the mPrato to set
	 */
	public void setmPrato(ModelPrato mPrato) {
		this.mPrato = mPrato;
	}
	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}
	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public ModelPedido() {}
	
	public ModelPedido(ModelPrato mPrato, int quantidade) {
		this.mPrato = mPrato;
		this.quantidade = quantidade;
	}
}
