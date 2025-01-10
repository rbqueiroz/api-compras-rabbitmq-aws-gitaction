package br.com.renequeiroz.compra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import br.com.renequeiroz.compra.config.Producer;
import br.com.renequeiroz.compra.model.Pedido;
import br.com.renequeiroz.compra.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final Producer producer;

    public Pedido salvar(Pedido pedido) {
        pedido = pedidoRepository.save(pedido);
        producer.enviarPedido(pedido);
        return pedido;
    }
    /*

    public Pedido buscarOuFalharPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(()-> new EntidadeNaoEncontradaException("O pedido de id: " + id + " nao existe na base de dados!"));
    }

    public void excluir(Long id) {
        Pedido pedido = buscarOuFalharPorId(id);
        pedidoRepository.deleteById(pedido.getId());
    }
    */

}