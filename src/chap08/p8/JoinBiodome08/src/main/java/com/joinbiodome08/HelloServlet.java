package com.joinbiodome08;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "postServlet", value = "/posts/*")
public class HelloServlet extends HttpServlet {

    private UserManager userManager = new UserManager();
    private PostManager postManager = new PostManager();
    private Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer()).create();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Transaction transaction = null;
        try {
            PostRequest postRequest = gson.fromJson(request.getReader(), PostRequest.class);
            Post post = postRequest.toEntity();

            transaction = new Transaction(post, "CREATE");
            postManager.save(post);
            Random random = new Random(System.currentTimeMillis());
            int randomPoint = random.nextInt(10) + 1;
            User user = userManager.findUser(post.getWriter());
            userManager.increasePoint(post.getWriter(), randomPoint);

            sendResponse(response, HttpServletResponse.SC_OK, gson.toJson(Map.of("post", post, "user", user, "RandomPoint", randomPoint)));
        } catch (IllegalArgumentException e) {
            sendResponse(response,HttpServletResponse.SC_BAD_REQUEST, gson.toJson(e.getMessage()));
        } catch (UserPointException e) {
            postManager.rollback(transaction);
            sendResponse(response,HttpServletResponse.SC_BAD_REQUEST, gson.toJson(e.getMessage()));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Transaction transaction = null;
        try {
        Long postId = Long.parseLong(request.getPathInfo().substring(1));
            Post post = postManager.findPostBy(postId);
            transaction = new Transaction(post, "DELETE");
            postManager.removePost(postId);
            userManager.decreasePoint(post.getWriter(), 3);
            sendResponse(response, HttpServletResponse.SC_OK, gson.toJson(post));
        } catch (IllegalArgumentException e) {
            sendResponse(response,HttpServletResponse.SC_BAD_REQUEST, gson.toJson(e.getMessage()));
        } catch (UserPointException e) {
            postManager.rollback(transaction);
            sendResponse(response,HttpServletResponse.SC_BAD_REQUEST, gson.toJson(e.getMessage()));
        }
    }

    private void sendResponse(HttpServletResponse response, int statusCode, String content) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(statusCode);
        response.getWriter().write(content);
    }
}