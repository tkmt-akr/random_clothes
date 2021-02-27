package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cloth;
import utils.DBUtil;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        // 該当のIDのデータ1件のみをデータベースから取得
        Cloth c = em.find(Cloth.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        // データとセッションIDをリクエストスコープに登録
        request.setAttribute("cloth", c);
        request.setAttribute("_token", request.getSession().getId());

        /*
        データが存在しているときのみ
        IDをセッションスコープに登録
        */
        if(c != null) {
            request.getSession().setAttribute("cloth_id", c.getId());
        }

        // メッセージIDをセッションスコープに登録
        request.getSession().setAttribute("cloth_id", c.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/display/edit.jsp");
        rd.forward(request, response);
    }
}