const sorteoJuegos = document.querySelector("#sorteoJuegos");
const ruleta = document.querySelector("#ruleta");
const formOpcionesJuego = document.querySelector("#formOpcionesJuego");
const opcionesJuego = document.querySelector("#opcionesJuego");
const listaOpcionesJuego = document.querySelector("#listaOpcionesJuego");
const btnSortearJuego = document.querySelector("#btnSortearJuego");
const btnCentroRuleta = document.querySelector("#btnCentroRuleta");
const btnAbrirEquipos = document.querySelector("#btnAbrirEquipos");
const resultadoJuego = document.querySelector("#resultadoJuego");
const moduloEquipos = document.querySelector("#moduloEquipos");
const formCantidad = document.querySelector("#formCantidad");
const formParticipantes = document.querySelector("#formParticipantes");
const camposParticipantes = document.querySelector("#camposParticipantes");
const btnVolverCantidad = document.querySelector("#btnVolverCantidad");
const btnReiniciar = document.querySelector("#btnReiniciar");
const equiposContenedor = document.querySelector("#equipos");
const partidosContenedor = document.querySelector("#partidos");
const tablaContenedor = document.querySelector("#tabla");
const rondaActual = document.querySelector("#rondaActual");

let equipos = [];
let partidos = [];
let ronda = 0;
let integrantesPorEquipo = 2;

class Juego {
    constructor(nombre, anguloCentral = 0, color = "#247447") {
        this.nombre = nombre;
        this.anguloCentral = anguloCentral;
        this.color = color;
    }

    esCanchitas() {
        return this.nombre.trim().toLowerCase() === "canchitas";
    }
}

class GestorOpcionesJuego {
    constructor({ campoOpciones, listaOpciones }) {
        this.campoOpciones = campoOpciones;
        this.listaOpciones = listaOpciones;
    }

    obtenerNombres() {
        return this.campoOpciones.value
            .split("\n")
            .map((opcion) => opcion.trim())
            .filter(Boolean);
    }

    validar(nombres) {
        if (nombres.length < 2) {
            alert("Ingresa minimo 2 opciones para la ruleta.");
            return false;
        }

        const nombresSinRepetir = new Set(nombres.map((nombre) => nombre.toLowerCase()));
        if (nombresSinRepetir.size !== nombres.length) {
            alert("No repitas opciones en la ruleta.");
            return false;
        }

        return true;
    }

    mostrar(nombres) {
        this.listaOpciones.innerHTML = "";
        nombres.forEach((nombre) => {
            const opcion = document.createElement("span");
            opcion.textContent = nombre;
            this.listaOpciones.appendChild(opcion);
        });
    }
}

class RuletaDeJuegos {
    constructor({ nombresIniciales, ruleta, botonGirar, botonCentro, botonAbrirEquipos, resultado, gestorOpciones }) {
        this.colores = ["#247447", "#2c5fd5", "#df6f5f", "#7a3fd5", "#f5a623", "#0f9b8e"];
        this.juegos = [];
        this.nombresIniciales = nombresIniciales;
        this.ruleta = ruleta;
        this.botonGirar = botonGirar;
        this.botonCentro = botonCentro;
        this.botonAbrirEquipos = botonAbrirEquipos;
        this.resultado = resultado;
        this.gestorOpciones = gestorOpciones;
        this.giroActual = 0;
        this.juegoSorteado = null;
    }

    iniciar() {
        this.actualizarOpciones(this.nombresIniciales);
        this.botonGirar.addEventListener("click", () => this.sortear());
        this.botonCentro.addEventListener("click", () => this.sortear());
        this.botonAbrirEquipos.addEventListener("click", () => this.abrirModuloEquipos());
    }

    actualizarOpciones(nombres) {
        if (!this.gestorOpciones.validar(nombres)) {
            return;
        }

        this.juegos = nombres.map((nombre, indice) => {
            const anguloCentral = (360 / nombres.length) * indice + (360 / nombres.length) / 2;
            return new Juego(nombre, anguloCentral, this.colores[indice % this.colores.length]);
        });

        this.juegoSorteado = null;
        this.botonAbrirEquipos.classList.add("oculto");
        this.resultado.textContent = "Esperando sorteo.";
        ocultarMundialito();
        this.renderizarRuleta();
        this.gestorOpciones.mostrar(nombres);
    }

    renderizarRuleta() {
        const tamanioSector = 360 / this.juegos.length;
        const sectores = this.juegos.map((juego, indice) => {
            const inicio = indice * tamanioSector;
            const fin = inicio + tamanioSector;
            return `${juego.color} ${inicio}deg ${fin}deg`;
        });

        this.ruleta.style.background = `conic-gradient(${sectores.join(", ")})`;
        this.ruleta.querySelectorAll(".opcion-ruleta").forEach((opcion) => opcion.remove());

        this.juegos.forEach((juego) => {
            const etiqueta = document.createElement("div");
            etiqueta.className = "opcion-ruleta";
            etiqueta.textContent = juego.nombre;
            etiqueta.style.transform = this.obtenerTransformacionEtiqueta(juego);
            this.ruleta.insertBefore(etiqueta, this.botonCentro);
        });
    }

    obtenerTransformacionEtiqueta(juego) {
        const radioEtiqueta = this.ruleta.closest(".sorteo-compacto") ? 60 : 92;
        return `translate(-50%, -50%) rotate(${juego.anguloCentral}deg) translateY(-${radioEtiqueta}px) rotate(calc(-${juego.anguloCentral}deg - var(--giro-ruleta, 0deg)))`;
    }

    sortear() {
        const juego = this.obtenerJuegoAleatorio();
        this.juegoSorteado = juego;
        this.bloquearGiro(true);
        this.botonAbrirEquipos.classList.add("oculto");
        this.resultado.textContent = "Girando...";

        this.girarHasta(juego);

        window.setTimeout(() => {
            this.bloquearGiro(false);
            this.mostrarResultado(juego);

            if (!juego.esCanchitas()) {
                ocultarMundialito();
                this.renderizarRuleta();
            }
        }, 3100);
    }

    obtenerJuegoAleatorio() {
        const indice = Math.floor(Math.random() * this.juegos.length);
        return this.juegos[indice];
    }

    girarHasta(juego) {
        // La flecha apunta arriba; por eso compensamos con 360 - anguloCentral.
        this.giroActual = Math.ceil(this.giroActual / 360) * 360 + 1440 + (360 - juego.anguloCentral);
        this.ruleta.style.transform = `rotate(${this.giroActual}deg)`;
        this.ruleta.style.setProperty("--giro-ruleta", `${this.giroActual}deg`);
    }

    bloquearGiro(estaGirando) {
        this.botonGirar.disabled = estaGirando;
        this.botonCentro.disabled = estaGirando;
    }

    mostrarResultado(juego) {
        this.resultado.innerHTML = `Juego sorteado: <strong>${juego.nombre}</strong>`;
        this.botonAbrirEquipos.classList.remove("oculto");
    }

    abrirModuloEquipos() {
        if (!this.juegoSorteado) {
            return;
        }

        mostrarModuloEquipos();
        this.renderizarRuleta();
        this.resultado.innerHTML = `Juego sorteado: <strong>${this.juegoSorteado.nombre}</strong>`;
    }
}

class ConfiguracionEquipos {
    constructor(cantidadParticipantes, integrantesPorEquipo) {
        this.cantidadParticipantes = cantidadParticipantes;
        this.integrantesPorEquipo = integrantesPorEquipo;
    }

    esValida() {
        return Number.isInteger(this.cantidadParticipantes)
            && Number.isInteger(this.integrantesPorEquipo)
            && this.cantidadParticipantes >= 2
            && this.integrantesPorEquipo >= 1
            && this.cantidadParticipantes >= this.integrantesPorEquipo * 2
            && this.cantidadParticipantes % this.integrantesPorEquipo === 0;
    }
}

class Equipo {
    constructor(numero, jugadores) {
        this.id = generarId();
        this.nombre = `Equipo ${numero}`;
        this.jugadores = jugadores;
        this.puntos = 0;
        this.partidosGanados = 0;
        this.eliminado = false;
    }
}

class SorteadorEquipos {
    constructor(tamanoEquipo) {
        this.tamanoEquipo = tamanoEquipo;
    }

    distribuir(nombres) {
        const mezclados = mezclar([...nombres]);
        const resultado = [];

        for (let i = 0; i < mezclados.length; i += this.tamanoEquipo) {
            resultado.push(new Equipo(resultado.length + 1, mezclados.slice(i, i + this.tamanoEquipo)));
        }

        return resultado;
    }
}

const ruletaDeJuegos = new RuletaDeJuegos({
    nombresIniciales: ["Canchitas", "Billar", "Yenga"],
    ruleta,
    botonGirar: btnSortearJuego,
    botonCentro: btnCentroRuleta,
    botonAbrirEquipos: btnAbrirEquipos,
    resultado: resultadoJuego,
    gestorOpciones: new GestorOpcionesJuego({
        campoOpciones: opcionesJuego,
        listaOpciones: listaOpcionesJuego
    })
});

// Inicializa la primera pantalla: la ruleta decide que juego se jugara.
ruletaDeJuegos.iniciar();

formOpcionesJuego.addEventListener("submit", (event) => {
    event.preventDefault();
    ruletaDeJuegos.actualizarOpciones(ruletaDeJuegos.gestorOpciones.obtenerNombres());
});

formCantidad.addEventListener("submit", (event) => {
    event.preventDefault();
    // Este formulario pertenece al modulo de Equipos.
    const cantidad = Number(document.querySelector("#cantidad").value);
    const tamanoEquipo = Number(document.querySelector("#integrantesEquipo").value);
    const configuracion = new ConfiguracionEquipos(cantidad, tamanoEquipo);

    if (!configuracion.esValida()) {
        alert("La configuracion debe formar minimo 2 equipos completos.");
        return;
    }

    integrantesPorEquipo = tamanoEquipo;
    crearCamposParticipantes(cantidad);
    formCantidad.classList.add("oculto");
    formParticipantes.classList.remove("oculto");
});

formParticipantes.addEventListener("submit", (event) => {
    event.preventDefault();
    // Con los nombres cargados, se distribuyen los equipos de manera aleatoria.
    const nombres = [...document.querySelectorAll(".nombre-participante")]
        .map((input) => input.value.trim())
        .filter(Boolean);

    if (nombres.length !== document.querySelectorAll(".nombre-participante").length) {
        alert("Completa todos los nombres de participantes.");
        return;
    }

    if (new Set(nombres.map((nombre) => nombre.toLowerCase())).size !== nombres.length) {
        alert("No repitas nombres de participantes.");
        return;
    }

    equipos = crearEquiposAleatorios(nombres, integrantesPorEquipo);
    mostrarResultadoEquipos();

    if (ruletaDeJuegos.juegoSorteado && ruletaDeJuegos.juegoSorteado.esCanchitas()) {
        ronda = 1;
        partidos = crearPartidos(equipos, ronda);
        mostrarTorneoCanchitas();
    } else {
        ronda = 0;
        partidos = [];
        ocultarTorneoCanchitas();
    }

    renderizarTodo();
});

btnVolverCantidad.addEventListener("click", () => {
    formParticipantes.classList.add("oculto");
    formCantidad.classList.remove("oculto");
    camposParticipantes.innerHTML = "";
    ocultarResultadoEquipos();
    ocultarTorneoCanchitas();
});

btnReiniciar.addEventListener("click", reiniciarTorneo);

function mostrarModuloEquipos() {
    // El modulo de Equipos aparece despues de que la ruleta ya eligio un juego.
    moduloEquipos.classList.remove("oculto");
    ocultarResultadoEquipos();
    ocultarTorneoCanchitas();
    sorteoJuegos.classList.add("sorteo-compacto");
}

function ocultarMundialito() {
    ocultarResultadoEquipos();
    ocultarTorneoCanchitas();
    moduloEquipos.classList.add("oculto");
    sorteoJuegos.classList.remove("sorteo-compacto");
}

function mostrarResultadoEquipos() {
    document.querySelectorAll(".modulo-equipos-resultado").forEach((elemento) => {
        elemento.classList.remove("oculto");
    });
}

function ocultarResultadoEquipos() {
    document.querySelectorAll(".modulo-equipos-resultado").forEach((elemento) => {
        elemento.classList.add("oculto");
    });
}

function mostrarTorneoCanchitas() {
    document.querySelectorAll(".modulo-canchitas").forEach((elemento) => {
        elemento.classList.remove("oculto");
    });
}

function ocultarTorneoCanchitas() {
    document.querySelectorAll(".modulo-canchitas").forEach((elemento) => {
        elemento.classList.add("oculto");
    });
}

function crearCamposParticipantes(cantidad) {
    camposParticipantes.innerHTML = "";
    for (let i = 1; i <= cantidad; i++) {
        const input = document.createElement("input");
        input.type = "text";
        input.required = true;
        input.maxLength = 35;
        input.placeholder = `Participante ${i}`;
        input.className = "nombre-participante";
        camposParticipantes.appendChild(input);
    }
}

function crearEquiposAleatorios(nombres, tamanoEquipo) {
    // SorteadorEquipos encapsula la regla de distribuir participantes en grupos.
    return new SorteadorEquipos(tamanoEquipo).distribuir(nombres);
}

function mezclar(lista) {
    for (let i = lista.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [lista[i], lista[j]] = [lista[j], lista[i]];
    }
    return lista;
}

function crearPartidos(equiposRonda, numeroRonda) {
    const equiposMezclados = mezclar([...equiposRonda]);
    const nuevosPartidos = [];
    let equipoLibre = null;

    if (equiposMezclados.length % 2 !== 0) {
        equipoLibre = equiposMezclados.pop();
    }

    for (let i = 0; i < equiposMezclados.length; i += 2) {
        nuevosPartidos.push({
            id: generarId(),
            tipo: "partido",
            ronda: numeroRonda,
            localId: equiposMezclados[i].id,
            visitanteId: equiposMezclados[i + 1].id,
            puntosLocal: 0,
            puntosVisitante: 0,
            terminado: false,
            ganadorId: null
        });
    }

    if (equipoLibre) {
        nuevosPartidos.push({
            id: generarId(),
            tipo: "descanso",
            ronda: numeroRonda,
            ganadorId: equipoLibre.id,
            terminado: true
        });
    }

    return nuevosPartidos;
}

function generarId() {
    if (window.crypto && crypto.randomUUID) {
        return crypto.randomUUID();
    }
    return `${Date.now()}-${Math.random().toString(16).slice(2)}`;
}

function sumarPunto(partidoId, lado) {
    const partido = partidos.find((item) => item.id === partidoId);
    if (!partido || partido.terminado) {
        return;
    }

    if (lado === "local") {
        partido.puntosLocal++;
    } else {
        partido.puntosVisitante++;
    }

    const equipoId = lado === "local" ? partido.localId : partido.visitanteId;
    const equipo = buscarEquipo(equipoId);
    equipo.puntos++;
    renderizarTodo();
}

function terminarPartido(partidoId) {
    const partido = partidos.find((item) => item.id === partidoId);
    if (!partido || partido.terminado) {
        return;
    }

    if (partido.puntosLocal === partido.puntosVisitante) {
        alert("No puede terminar empatado. Agrega un punto al equipo ganador.");
        return;
    }

    partido.terminado = true;
    partido.ganadorId = partido.puntosLocal > partido.puntosVisitante ? partido.localId : partido.visitanteId;

    const ganador = buscarEquipo(partido.ganadorId);
    const perdedorId = partido.ganadorId === partido.localId ? partido.visitanteId : partido.localId;
    const perdedor = buscarEquipo(perdedorId);

    ganador.partidosGanados++;
    perdedor.eliminado = true;

    if (partidos.every((item) => item.terminado)) {
        prepararSiguienteRonda();
    }

    renderizarTodo();
}

function prepararSiguienteRonda() {
    const clasificados = equipos.filter((equipo) => !equipo.eliminado);
    if (clasificados.length <= 1) {
        return;
    }

    ronda++;
    partidos = crearPartidos(clasificados, ronda);
}

function buscarEquipo(id) {
    return equipos.find((equipo) => equipo.id === id);
}

function renderizarTodo() {
    renderizarEquipos();
    renderizarPartidos();
    renderizarTabla();
    rondaActual.textContent = `Ronda ${ronda}`;
}

function renderizarEquipos() {
    if (equipos.length === 0) {
        equiposContenedor.className = "lista-vacia";
        equiposContenedor.textContent = "Todavia no hay equipos.";
        return;
    }

    equiposContenedor.className = "grid-equipos";
    equiposContenedor.innerHTML = equipos.map((equipo) => `
        <article class="equipo ${equipo.eliminado ? "" : "campeon"}">
            <h3>${equipo.nombre}</h3>
            <div class="jugadores">${equipo.jugadores.join(" + ")}</div>
            <strong>${equipo.eliminado ? "Eliminado" : "En competencia"}</strong>
        </article>
    `).join("");
}

function renderizarPartidos() {
    const campeon = obtenerCampeon();

    if (campeon) {
        partidosContenedor.className = "grid-partidos";
        partidosContenedor.innerHTML = `
            <div class="mensaje-final">
                Campeones: ${campeon.nombre} (${campeon.jugadores.join(" + ")})
            </div>
        `;
        return;
    }

    if (partidos.length === 0) {
        partidosContenedor.className = "lista-vacia";
        partidosContenedor.textContent = "Los partidos apareceran despues del sorteo.";
        return;
    }

    partidosContenedor.className = "grid-partidos";
    partidosContenedor.innerHTML = partidos.map((partido) => {
        if (partido.tipo === "descanso") {
            const equipoLibre = buscarEquipo(partido.ganadorId);
            return `
                <article class="partido campeon">
                    <h3>Clasifica directo en ronda ${partido.ronda}</h3>
                    <div class="jugadores">${equipoLibre.nombre}: ${equipoLibre.jugadores.join(" + ")}</div>
                </article>
            `;
        }s

        const local = buscarEquipo(partido.localId);
        const visitante = buscarEquipo(partido.visitanteId);
        const ganador = partido.ganadorId ? buscarEquipo(partido.ganadorId) : null;

        return `
            <article class="partido">
                <h3>Partido de ronda ${partido.ronda}</h3>
                <div class="marcador">
                    <div class="equipo-marcador">
                        <strong>${local.nombre}</strong>
                        <span class="jugadores">${local.jugadores.join(" + ")}</span>
                        <span class="puntos">${partido.puntosLocal}</span>
                    </div>
                    <span class="versus">VS</span>
                    <div class="equipo-marcador">
                        <strong>${visitante.nombre}</strong>
                        <span class="jugadores">${visitante.jugadores.join(" + ")}</span>
                        <span class="puntos">${partido.puntosVisitante}</span>
                    </div>
                </div>
                <div class="acciones-partido">
                    <button onclick="sumarPunto('${partido.id}', 'local')" ${partido.terminado ? "disabled" : ""}>+1 ${local.nombre}</button>
                    <button onclick="sumarPunto('${partido.id}', 'visitante')" ${partido.terminado ? "disabled" : ""}>+1 ${visitante.nombre}</button>
                    <button class="boton-secundario" onclick="terminarPartido('${partido.id}')" ${partido.terminado ? "disabled" : ""}>Terminar partido</button>
                </div>
                ${ganador ? `<div class="ganador">Ganador: ${ganador.nombre}</div>` : ""}
            </article>
        `;
    }).join("");
}

function renderizarTabla() {
    if (equipos.length === 0) {
        tablaContenedor.className = "lista-vacia";
        tablaContenedor.textContent = "Sin resultados registrados.";
        return;
    }

    const ordenados = [...equipos].sort((a, b) => {
        if (b.partidosGanados !== a.partidosGanados) {
            return b.partidosGanados - a.partidosGanados;
        }
        return b.puntos - a.puntos;
    });

    tablaContenedor.className = "grid-tabla";
    tablaContenedor.innerHTML = ordenados.map((equipo, index) => `
        <div class="fila-tabla ${index === 0 ? "campeon" : ""}">
            <span class="puesto">${index + 1}</span>
            <strong>${equipo.nombre}: ${equipo.jugadores.join(" + ")}</strong>
            <span class="dato-tabla"><span>Ganados</span><span class="numero-tabla">${equipo.partidosGanados}</span></span>
            <span class="dato-tabla"><span>Puntos</span><span class="numero-tabla">${equipo.puntos}</span></span>
            <span class="dato-tabla">${equipo.eliminado ? "Eliminado" : "Activo"}</span>
        </div>
    `).join("");
}

function obtenerCampeon() {
    const activos = equipos.filter((equipo) => !equipo.eliminado);
    return equipos.length > 0 && activos.length === 1 ? activos[0] : null;
}

function reiniciarTorneo() {
    equipos = [];
    partidos = [];
    ronda = 0;
    integrantesPorEquipo = 2;
    formParticipantes.classList.add("oculto");
    formCantidad.classList.remove("oculto");
    formCantidad.reset();
    camposParticipantes.innerHTML = "";
    ocultarResultadoEquipos();
    ocultarTorneoCanchitas();
    renderizarTodo();
}

renderizarTodo();
