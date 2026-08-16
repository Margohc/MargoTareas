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

formCantidad.addEventListener("submit", (event) => {
    event.preventDefault();
    const cantidad = Number(document.querySelector("#cantidad").value);

    if (!Number.isInteger(cantidad) || cantidad < 4 || cantidad % 2 !== 0) {
        alert("La cantidad debe ser par y minimo 4.");
        return;
    }

    crearCamposParticipantes(cantidad);
    formCantidad.classList.add("oculto");
    formParticipantes.classList.remove("oculto");
});

formParticipantes.addEventListener("submit", (event) => {
    event.preventDefault();
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

    equipos = crearEquiposAleatorios(nombres);
    ronda = 1;
    partidos = crearPartidos(equipos, ronda);
    renderizarTodo();
});

btnVolverCantidad.addEventListener("click", () => {
    formParticipantes.classList.add("oculto");
    formCantidad.classList.remove("oculto");
    camposParticipantes.innerHTML = "";
});

btnReiniciar.addEventListener("click", reiniciarTorneo);

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

function crearEquiposAleatorios(nombres) {
    const mezclados = mezclar([...nombres]);
    const resultado = [];

    for (let i = 0; i < mezclados.length; i += 2) {
        resultado.push({
            id: generarId(),
            nombre: `Equipo ${resultado.length + 1}`,
            jugadores: [mezclados[i], mezclados[i + 1]],
            puntos: 0,
            partidosGanados: 0,
            eliminado: false
        });
    }

    return resultado;
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
        }

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
            <span class="dato-tabla">Ganados: ${equipo.partidosGanados}</span>
            <span class="dato-tabla">Puntos: ${equipo.puntos}</span>
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
    formParticipantes.classList.add("oculto");
    formCantidad.classList.remove("oculto");
    formCantidad.reset();
    camposParticipantes.innerHTML = "";
    renderizarTodo();
}

renderizarTodo();
