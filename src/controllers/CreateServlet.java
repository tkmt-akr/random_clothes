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
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Cloth c = new Cloth();

            String title = request.getParameter("title");
            c.setTitle(title);

            //  ランダム処理
            String[] hat = {"赤", "青", "黄", "茶", "緑", "黒", "白"};
            String h = hat[(int)(Math.random() * 7)];
            c.setHat(h);
            String[] tops = {"赤", "青", "黄", "茶", "緑", "黒", "白"};
            String t = tops[(int)(Math.random() * 7)];
            c.setTops(t);
            String[] outerWear = {"赤", "青", "黄", "茶", "緑", "黒", "白"};
            String o = outerWear[(int)(Math.random() * 7)];
            c.setOuterWear(o);
            String[] pants = {"赤", "青", "黄", "茶", "緑", "黒", "白"};
            String p = pants[(int)(Math.random() * 7)];
            c.setPants(p);
            String[] socks = {"赤", "青", "黄", "茶", "緑", "黒", "白"};
            String so = socks[(int)(Math.random() * 7)];
            c.setSocks(so);
            String[] shoes = {"赤", "青", "黄", "茶", "緑", "黒", "白"};
            String s = shoes[(int)(Math.random() * 7)];
            c.setShoes(s);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            c.setCreated_at(currentTime);
            c.setUpdated_at(currentTime);

                // データベースに保存
                em.getTransaction().begin();
                em.persist(c);
                em.getTransaction().commit();
                request.getSession().setAttribute("flush", "登録が完了しました。");
                em.close();

                // indexのページにリダイレクト
                response.sendRedirect(request.getContextPath() + "/index");
        }
    }
}