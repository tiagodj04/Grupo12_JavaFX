package pt.upt.ei.lp.db;

import java.util.List;

public interface DataClient {
	public List<VendedorStand> findAllVendedoresStand();
	public VendedorStand findVendedorStand( String nome);
	public VendedorStand updateVendedorStand(String pass,String nome, List<CarroEletrico> carrosEletricos);
	public VendedorStand updateVendedorStand(String pass,String nome);
	public void removeVendedorStand(int id);
	public List<CarroEletrico> findAllCarrosEletricos();
	public CarroEletrico updateCarroEletrico(int id,String marca, String modelo, int ano,int kms, int cavalos, int autonomia, String descricao, double preco, boolean estado);
	public void removeCarroEletrico(int id);
	public CarroEletrico findCarroEletrico(int id);
}
