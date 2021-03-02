package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cloth;
import utils.DBUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            /*
            セッションスコープからIDを取得して
            該当のIDの1件のみをデータベースから取得
            */
            Cloth c = em.find(Cloth.class, (Integer)(request.getSession().getAttribute("cloth_id")));

            // フォームの内容を各フィールドに上書き
            String title = request.getParameter("title");
            c.setTitle(title);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            c.setUpdated_at(currentTime);       // 更新日時のみ上書き

                // データベースを更新
                em.getTransaction().begin();
                em.getTransaction().commit();
                request.getSession().setAttribute("flush", "更新が完了しました。");
                em.close();

                // セッションスコープ上の不要になったデータを削除
                request.getSession().removeAttribute("cloth_id");

                // indexページへリダイレクト
                response.sendRedirect(request.getContextPath() + "/index");
        }
    }
}