package br.edu.usj.ads.lpii.projeto_final_produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.usj.ads.lpii.projeto_final_produto.model.Album;
import br.edu.usj.ads.lpii.projeto_final_produto.model.AlbumRepository;
import br.edu.usj.ads.lpii.projeto_final_produto.model.Clientes;
import br.edu.usj.ads.lpii.projeto_final_produto.model.ClientesRepository;
import br.edu.usj.ads.lpii.projeto_final_produto.model.Musica;
import br.edu.usj.ads.lpii.projeto_final_produto.model.MusicaRepository;

@Controller
public class StoreController {

    @Autowired // Cada classe Repository quando declarada deve vir com uma @Autowired
    MusicaRepository musicaRepository;

    @Autowired
    ClientesRepository clientesRepository;

    @Autowired
    AlbumRepository albumRepository;

    //
    //

    /// Rotas GET ////

    @GetMapping(value = "/")
    public ModelAndView getDefaut() {

        ModelAndView modelAndView = new ModelAndView("view_main/index"); // Criando um construtor chamando o
                                                                         // templates/index
        return modelAndView;

    }

    @GetMapping(value = "/clientes")
    public ModelAndView getListClientes() {
        Clientes clientes = new Clientes();

        ModelAndView modelAndView = new ModelAndView("view_clientes/listclientes"); // Criando um construtor chamando o
        // templates/index
        modelAndView.addObject("clientes", clientes);
        modelAndView.addObject("historico", clientesRepository.findAll());
        return modelAndView;

    }

    @GetMapping(value = "/cadastro_clientes")
    public ModelAndView getCadClientes() {
        Clientes clientes = new Clientes();

        ModelAndView modelAndView = new ModelAndView("view_clientes/cadclientes"); // Criando um construtor chamando o
                                                                                   // templates/index
        modelAndView.addObject("clientes", clientes);
        return modelAndView;

    }

    @GetMapping(value = "/albuns")
    public ModelAndView getListAlbuns() {
        Album album = new Album();

        ModelAndView modelAndView = new ModelAndView("view_albuns/listalbuns"); // Criando um construtor chamando o
                                                                                // templates/index
        modelAndView.addObject("album", album);
        modelAndView.addObject("historico", albumRepository.findAll());
        return modelAndView;

    }

    @GetMapping(value = "/cadastro_albuns")
    public ModelAndView getCadAlbuns() {
        Album album = new Album();

        ModelAndView modelAndView = new ModelAndView("view_albuns/cadalbum"); // Criando um construtor chamando o
                                                                              // templates/index
        modelAndView.addObject("album", album);
        return modelAndView;

    }

    @GetMapping(value = "/musicas")
    public ModelAndView getListMusica() {
        Musica musica = new Musica();

        ModelAndView modelAndView = new ModelAndView("view_musicas/listmusicas"); // Criando um construtor chamando o
        // templates/index
        modelAndView.addObject("musica", musica);
        modelAndView.addObject("historico", musicaRepository.findAll());

        return modelAndView;

    }

    @GetMapping(value = "/cadastro_musicas")
    public ModelAndView getCadMusica() {
        Musica musica = new Musica();

        ModelAndView modelAndView = new ModelAndView("view_musicas/cadmusicas"); // Criando um construtor chamando o
                                                                                 // templates/index
        modelAndView.addObject("musica", musica);
        modelAndView.addObject("lista_albuns", albumRepository.findAll());
        System.out.println("TESTESTESTW" + albumRepository.findAll());

        return modelAndView;

    }

    @GetMapping(value = "/visualizar_clientes")
    public ModelAndView getVisualizarClientes() {

        ModelAndView modelAndView = new ModelAndView("view_clientes/vclientes"); // Criando um construtor chamando o
                                                                                 // templates/index
        modelAndView.addObject("mensagem", " Cadastrado com Sucesso");
        modelAndView.addObject("historico", clientesRepository.findAll());
        return modelAndView;

    }

    @GetMapping(value = "/visualizar_albuns")
    public ModelAndView getVisualizarAlbuns() {

        ModelAndView modelAndView = new ModelAndView("view_albuns/valbum"); // Criando um construtor chamando o
                                                                            // templates/index
        modelAndView.addObject("mensagem", " Cadastrado com Sucesso");
        modelAndView.addObject("historico", albumRepository.findAll());
        return modelAndView;

    }

    @GetMapping(value = "/visualizar_musicas")
    public ModelAndView getVisualizarMusicas() {

        ModelAndView modelAndView = new ModelAndView("view_musicas/vmusicas"); // Criando um construtor chamando o
                                                                               // templates/index
        modelAndView.addObject("mensagem", " Cadastrado com Sucesso");
        modelAndView.addObject("historico", musicaRepository.findAll());
        return modelAndView;

    }

    @GetMapping(value = "/pesquisa")
    public ModelAndView getPesquisa() {

        ModelAndView modelAndView = new ModelAndView("view_main/pesquisa"); // Criando um construtor chamando o
                                                                            // templates/index
        return modelAndView;

    }

    @GetMapping(value = "/pesquisar/{nome}")
    public List<Clientes> getPesquisarNome(@PathVariable String nome) {
        List<Clientes> lista = clientesRepository.findByNomeContainingIgnoreCase(nome);
        return lista;

    } 

    @GetMapping(value = "/contatos")
    public ModelAndView getContatos() {

        ModelAndView modelAndView = new ModelAndView("view_main/contatos"); // Criando um construtor chamando o
                                                                            // templates/index
        return modelAndView;

    }

    @GetMapping(value = "/visualizar_clientes_detalhes/{id}")
    public ModelAndView getClientesDetalhes(@PathVariable Long id) {

        Clientes clientes = clientesRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("view_clientes/desc_clientes");

        modelAndView.addObject("clientes", clientes);

        return modelAndView;
    }

    @GetMapping(value = "/visualizar_clientes_detalhes/clientes")
    public String getRetornoClientesClientes() {
        // templates/index
        return "redirect:/clientes";
    }

    @GetMapping(value = "/visualizar_clientes_detalhes/albuns")
    public String getRetornoClientesAlbuns() {
        // templates/index
        return "redirect:/albuns";
    }

    @GetMapping(value = "/visualizar_clientes_detalhes/musicas")
    public String getRetornoClientesMusicas() {
        return "redirect:/musicas";
    }

    @GetMapping(value = "/visualizar_clientes_detalhes/contatos")
    public String getRetornoClientesContatos() {
        return "redirect:/contatos";
    }

    @GetMapping(value = "/visualizar_clientes_detalhes/pesquisa")
    public String getRetornoClientesPesquisa() {
        return "redirect:/pesquisa";
    }

    @GetMapping(value = "/visualizar_clientes_detalhes/visualizar_clientes")
    public String getRetornoClientesVisualizarClientes() {
        return "redirect:/visualizar_clientes";
    }

    @GetMapping(value = "/visualizar_clientes_detalhes/visualizar_albuns")
    public String getRetornoClientesVisualizarAlbuns() {
        return "redirect:/visualizar_albuns";
    }

    @GetMapping(value = "/visualizar_clientes_detalhes/visualizar_musicas")
    public String getRetornoClientesVisualizarMusicas() {
        return "redirect:/visualizar_musicas";
    }

    @GetMapping(value = "/visualizar_album_detalhes/{id}")
    public ModelAndView getAlbDetalhes(@PathVariable Long id) {

        Album album = albumRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("view_albuns/desc_albuns");

        modelAndView.addObject("album", album);

        return modelAndView;
    }

    @GetMapping(value = "/visualizar_album_detalhes/clientes")
    public String getRetornoAlbunsClientes() {
        // templates/index
        return "redirect:/clientes";
    }

    @GetMapping(value = "/visualizar_album_detalhes/albuns")
    public String getRetornoAlbunsAlbuns() {
        // templates/index
        return "redirect:/albuns";
    }

    @GetMapping(value = "/visualizar_album_detalhes/musicas")
    public String getRetornoAlbunsMusicas() {
        // templates/index
        return "redirect:/musicas";
    }

    @GetMapping(value = "/visualizar_album_detalhes/contatos")
    public String getRetornoAlbunsContatos() {
        // templates/index
        return "redirect:/contatos";
    }

    @GetMapping(value = "/visualizar_album_detalhes/pesquisa")
    public String getRetornoAlbunsPesquisa() {
        // templates/index
        return "redirect:/pesquisa";
    }

    @GetMapping(value = "/visualizar_album_detalhes/visualizar_clientes")
    public String getRetDetalhesVisualizarClientes() {
        return "redirect:/visualizar_clientes";
    }

    @GetMapping(value = "/visualizar_album_detalhes/visualizar_albuns")
    public String getRetDetalhesVisualizaralbuns() {
        return "redirect:/visualizar_albuns";
    }

    @GetMapping(value = "/visualizar_album_detalhes/visualizar_musicas")
    public String getRetDetalhesVisualizarMusicas() {
        return "redirect:/visualizar_musicas";
    }

    @GetMapping(value = "/visualizar_musicas_detalhes/{id}")
    public ModelAndView getMusicaDetalhetes(@PathVariable Long id) {

        Musica musica = musicaRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("view_musicas/desc_musica");

        modelAndView.addObject("musica", musica);

        return modelAndView;
    }

    @GetMapping(value = "/visualizar_musicas_detalhes/clientes")
    public String getRetornoMusicasClientes() {
        // templates/index
        return "redirect:/clientes";
    }

    @GetMapping(value = "/visualizar_musicas_detalhes/albuns")
    public String getRetornoMusicasAlbuns() {
        // templates/index
        return "redirect:/albuns";
    }

    @GetMapping(value = "/visualizar_musicas_detalhes/musicas")
    public String getRetornoMusicasMusicas() {
        // templates/index
        return "redirect:/musicas";
    }

    @GetMapping(value = "/visualizar_musicas_detalhes/contatos")
    public String getRetornoMusicasContatos() {
        // templates/index
        return "redirect:/contatos";
    }

    @GetMapping(value = "/visualizar_musicas_detalhes/pesquisa")
    public String getRetornoMusicasPesquisa() {
        // templates/index
        return "redirect:/pesquisa";
    }

    @GetMapping(value = "/visualizar_musicas_detalhes/visualizar_clientes")
    public String getRetDetMusicasVisualizarClientes() {
        return "redirect:/visualizar_clientes";
    }

    @GetMapping(value = "/visualizar_musicas_detalhes/visualizar_albuns")
    public String getRetDetMusicasVisualizarAlbuns() {
        return "redirect:/visualizar_albuns";
    }

    @GetMapping(value = "/visualizar_musicas_detalhes/visualizar_musicas")
    public String getRetDetMusicasVisualizarMusicas() {
        return "redirect:/visualizar_musicas";
    }

    @GetMapping(value = "/editar_clientes/{id}")
    public ModelAndView getEditarClientes(@PathVariable Long id) {
        // retornar o formulario com a clientes ID preenchida no form
        Clientes clientes = clientesRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("view_clientes/cadclientes");
        modelAndView.addObject("clientes", clientes);
        return modelAndView;
    }

    @GetMapping(value = "/editar_albuns/{id}")
    public ModelAndView getEditarAlbuns(@PathVariable Long id) {
        Album album = albumRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("view_albuns/cadalbum");
        modelAndView.addObject("album", album);
        return modelAndView;
    }

    @GetMapping(value = "/editar_musicas/{id}")
    public ModelAndView getEditarMusicas(@PathVariable Long id) {
        Musica musica = musicaRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("view_musicas/cadmusicas");
        modelAndView.addObject("musica", musica);
        modelAndView.addObject("lista_albuns", albumRepository.findAll());

        return modelAndView;
    }

    @GetMapping(value = "/editar_clientes/clientes")
    public String getRetornoEditClienteClientes() {
        return "redirect:/clientes";
    }

    @GetMapping(value = "/editar_clientes/albuns")
    public String getRetornoEditClienteAlbuns() {
        return "redirect:/albuns";
    }

    @GetMapping(value = "/editar_clientes/musicas")
    public String getRetornoEditClienteMusicas() {
        return "redirect:/musicas";
    }

    @GetMapping(value = "/editar_clientes/contatos")
    public String getRetornoEditClienteContatos() {
        return "redirect:/contatos";
    }

    @GetMapping(value = "/editar_clientes/pesquisa")
    public String getRetornoEditClientePesquisa() {
        return "redirect:/pesquisa";
    }

    @GetMapping(value = "/editar_clientes/visualizar_clientes")
    public String getRetornoEditClienteVisualizarClientes() {
        return "redirect:/visualizar_clientes";
    }

    @GetMapping(value = "/editar_clientes/visualizar_albuns")
    public String getRetornoEditClienteVisualizarAlbuns() {
        return "redirect:/visualizar_albuns";
    }

    @GetMapping(value = "/editar_clientes/visualizar_musicas")
    public String getRetornoEditClienteVisualizarMusicas() {
        return "redirect:/visualizar_musicas";
    }

    @GetMapping(value = "/editar_musicas/clientes")
    public String getRetornoEditMusicasClientes() {
        return "redirect:/clientes";
    }

    @GetMapping(value = "/editar_musicas/albuns")
    public String getRetornoEditMusicasAlbuns() {
        return "redirect:/albuns";
    }

    @GetMapping(value = "/editar_musicas/musicas")
    public String getRetornoEditMusicasMusicas() {
        return "redirect:/musicas";
    }

    @GetMapping(value = "/editar_musicas/contatos")
    public String getRetornoEditMusicasContatos() {
        return "redirect:/contatos";
    }

    @GetMapping(value = "/editar_musicas/pesquisa")
    public String getRetornoEditMusicasPesquisa() {
        return "redirect:/pesquisa";
    }

    @GetMapping(value = "/editar_musicas/visualizar_clientes")
    public String getRetornoEditMusicasVisualizarClientes() {
        return "redirect:/visualizar_clientes";
    }

    @GetMapping(value = "/editar_musicas/visualizar_albuns")
    public String getRetornoEditMusicasVisualizarAlbuns() {
        return "redirect:/visualizar_albuns";
    }

    @GetMapping(value = "/editar_musicas/visualizar_musicas")
    public String getRetornoEditMusicasVisualizarMusicas() {
        return "redirect:/visualizar_musicas";
    }

    @GetMapping(value = "/editar_albuns/clientes")
    public String getRetornoEditAlbunsClientes() {
        return "redirect:/clientes";
    }

    @GetMapping(value = "/editar_albuns/albuns")
    public String getRetornoEditAlbunsAlbuns() {
        return "redirect:/albuns";
    }

    @GetMapping(value = "/editar_albuns/musicas")
    public String getRetornoEditAlbunsMusicas() {
        return "redirect:/musicas";
    }

    @GetMapping(value = "/editar_albuns/contatos")
    public String getRetornoEditAlbunsContatos() {
        return "redirect:/contatos";
    }

    @GetMapping(value = "/editar_albuns/pesquisa")
    public String getRetornoEditAlbunsPesquisa() {
        return "redirect:/pesquisa";
    }

    @GetMapping(value = "/editar_albuns/visualizar_clientes")
    public String getRetornoEditAlbunsVisualizarClientes() {
        return "redirect:/visualizar_clientes";
    }

    @GetMapping(value = "/editar_albuns/visualizar_albuns")
    public String getRetornoEditAlbunsVisualizarAlbuns() {
        return "redirect:/visualizar_albuns";
    }

    @GetMapping(value = "/editar_albuns/visualizar_musicas")
    public String getRetornoEditAlbunsVisualizarMusicas() {
        return "redirect:/visualizar_musicas";
    }

    @GetMapping(value = "/deletar_clientes/{id}")
    public String getDeletarClientes(@PathVariable Long id) {
        clientesRepository.deleteById(id);

        return "redirect:/clientes";
    }

    @GetMapping(value = "/deletar_albuns/{id}")
    public String getDeletarAlbuns(@PathVariable Long id) {
        albumRepository.deleteById(id);

        return "redirect:/albuns";
    }

    @GetMapping(value = "/deletar_musicas/{id}")
    public String getDeletarMusicas(@PathVariable Long id) {
        musicaRepository.deleteById(id);

        return "redirect:/musicas";
    }

    /*
     * @GetMapping(value = "/deleta/visualizar") public ModelAndView getDeletar() {
     * 
     * ModelAndView modelAndView = new ModelAndView("visualizar"); // Criando um
     * construtor chamando o templates/index modelAndView.addObject("historico",
     * operacaoRepository.findAll()); return modelAndView; }
     */

    ///////////// ROTAS POST @PostMappinga anotação mapeia solicitações HTTP POST
    ///////////// para métodos específicos do manipulador. É uma anotação composta
    ///////////// que atua como um atalho para @RequestMapping(method =
    ///////////// RequestMethod.POST)./////

    @PostMapping(value = "/cadastro_clientes")
    public String postCadClientes(Clientes clientes) {

        System.out.println("Passei por aqui");

        clientesRepository.save(clientes);

        ModelAndView modelAndView = new ModelAndView("view_clientes/listclientes"); // Criando um construtor chamando o
        // templates/index

        modelAndView.addObject("mensagem", " Cadastrado com Sucesso");
        modelAndView.addObject("historico", clientesRepository.findAll());

        return "redirect:/clientes";

    };

    @PostMapping(value = "/cadastro_albuns")
    public String postCadAlbum(Album album) {

        System.out.println("Passei por aqui Album");

        albumRepository.save(album);
        System.out.println(album);

        ModelAndView modelAndView = new ModelAndView("view_albuns/listalbuns"); // Criando um construtor chamando o
                                                                                // templates/index

        modelAndView.addObject("mensagem", " Cadastrado com Sucesso");
        modelAndView.addObject("historico", albumRepository.findAll());

        return "redirect:/albuns";
    }

    @PostMapping(value = "/cadastro_musicas")
    public String postCadMusica(Musica musica) {

        System.out.println("Passei por aqui Produtos");

        musicaRepository.save(musica);

        ModelAndView modelAndView = new ModelAndView("view_musicas/listmusicas"); // Criando um construtor chamando o
        // templates/index

        modelAndView.addObject("mensagem", " Cadastrado com Sucesso");
        modelAndView.addObject("historico", musicaRepository.findAll());
        modelAndView.addObject("lista_albuns", albumRepository.findAll());
        System.out.println(albumRepository.findAll());
        return "redirect:/musicas";
    }

}