package br.com.InterfaceDao;

import br.com.crud.domain.Cliente;

import java.util.Collection;

public interface IClienteDao {
    public void cadastrar(Cliente cleinte);
    public void excluir(Long cpf);
    public void alterar(Cliente cliente);
    public Cliente consultar(Long cpf);
    public Collection<Cliente> buscarTodos();
}
