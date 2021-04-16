package chess.controller.web;

import chess.controller.web.dto.RoomDto;
import chess.service.ChessService;
import chess.service.RoomService;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class WebChessController {
    private final ChessService chessService;
    private final RoomService roomService;

    public WebChessController(ChessService chessService, RoomService roomService) {
        this.chessService = chessService;
        this.roomService = roomService;
    }

    public void run() {
        get("/", this::mainPage);
        get("/create", this::createRoom);
        get("/delete/:roomId", this::deleteRoom);
        get("/game/:roomId", this::loadGame);
        post("/game/:roomId/move", this::move);
    }

    private Object mainPage(Request request, Response response) {
        Map<String, Object> model = new HashMap<>();
        model.put("roomList", roomService.load());
        return render(model, "index.html");
    }

    private Object createRoom(Request request, Response response) {
        roomService.create(request.queryParams("roomName"));
        return mainPage(request, response);
    }

    private Object deleteRoom(Request request, Response response) {
        Long roomId = Long.parseLong(request.params(":roomId"));
        roomService.delete(roomId);
        return mainPage(request, response);
    }


    private Object loadGame(Request request, Response response) {
        Long roomId = Long.parseLong(request.params(":roomId"));
        Map<String, Object> model = chessService.load(roomId);
        model.put("room", new RoomDto(roomId, ""));
        return render(model, "chessboard.html");
    }

    private Object move(Request request, Response response) {
        Long roomId = Long.parseLong(request.params(":roomId"));
        Map<String, Object> model = chessService.move(roomId, request.queryParams("command"));
        model.put("room", new RoomDto(roomId, ""));
        return render(model, "chessboard.html");
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
