package br.com.renequeiroz.compra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.renequeiroz.compra.model.Pedido;
import br.com.renequeiroz.compra.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> salvar(@RequestBody @Valid Pedido pedido) {
        return ResponseEntity.ok(pedidoService.salvar(pedido));
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.buscarOuFalharPorId(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        pedidoService.excluir(id);
    }
*/
}