package br.com.implement;

import br.com.InterfaceDao.IClienteDao;
import br.com.crud.domain.Cliente;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDao implements IClienteDao {

    private Map<Long, Cliente> mapCliente;

    public ClienteMapDao(){
        this.mapCliente = new HashMap<>();
    }

    @Override
    public void cadastrar(Cliente cliente) {
        if(this.mapCliente.containsKey(cliente.getCpf())){
            System.out.println("Cliente já cadastrado!!!");
        }

        this.mapCliente.put(cliente.getCpf(), cliente);

    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.mapCliente.get(cpf);

        if(clienteCadastrado != null){
            this.mapCliente.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.mapCliente.get(cliente.getCpf());

        if(clienteCadastrado != null){
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
            clienteCadastrado.setNumero(cliente.getNumero());
        }


    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.mapCliente.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.mapCliente.values();
    }
}
