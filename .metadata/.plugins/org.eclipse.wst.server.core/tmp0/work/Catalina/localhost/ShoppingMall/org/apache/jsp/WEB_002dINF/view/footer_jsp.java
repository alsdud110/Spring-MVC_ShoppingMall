/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.65
 * Generated at: 2021-04-29 07:50:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<hr>\r\n");
      out.write("<footer>\r\n");
      out.write("\r\n");
      out.write("        <!-- Footer Start-->\r\n");
      out.write("        <div class=\"footer-area footer-padding\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row d-flex justify-content-between\">\r\n");
      out.write("                    <div class=\"col-xl-3 col-lg-1 col-md-1 col-sm-3\">\r\n");
      out.write("                        <div class=\"single-footer-caption mb-50\">\r\n");
      out.write("                            <div class=\"single-footer-caption mb-10\">\r\n");
      out.write("                                <!-- logo -->\r\n");
      out.write("                                <div class=\"footer-logo\">\r\n");
      out.write("                                    <a href=\"index.html\"><img src=\"#\" alt=\"\"></a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"footer-tittle\">\r\n");
      out.write("                                    <div class=\"footer-pera\"> \r\n");
      out.write("                                      <img src=\"https://i.pinimg.com/236x/7e/64/6b/7e646bd7120da69b67240999098e2984.jpg\">\r\n");
      out.write("\r\n");
      out.write("                                </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-xl-2 col-lg-3 col-md-3 col-sm-5\">\r\n");
      out.write("                        <div class=\"single-footer-caption mb-50\">\r\n");
      out.write("                            <div class=\"footer-tittle\">\r\n");
      out.write("                            <P align=\"center\">  \r\n");
      out.write("                            <br>\r\n");
      out.write("                            <br>\r\n");
      out.write("                                <h4>CS CENTER</h4>\r\n");
      out.write("                                <ul>\r\n");
      out.write("                                    <li><a href=\"#\">00-000-0000</a></li>\r\n");
      out.write("\r\n");
      out.write("                                    <li><a href=\"#\"> office hours : <br>AM 10:00 - PM 05:00</a></li>\r\n");
      out.write("                                    <li><a href=\"#\"> break time : <br>PM 01:00 - PM 02:00</a></li>\r\n");
      out.write("                                    <li><a href=\"#\"> days off : sat/sun/holiday </a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-xl-2 col-lg-3 col-md-3 col-sm-5\">\r\n");
      out.write("                        <div class=\"single-footer-caption mb-50\">\r\n");
      out.write("                            <div class=\"footer-tittle\">\r\n");
      out.write("                            <P align=\"center\">  \r\n");
      out.write("                            <br>\r\n");
      out.write("                            <br>\r\n");
      out.write("                                <h4>BANK INFO</h4>\r\n");
      out.write("                                <ul>\r\n");
      out.write("                                    <li><a href=\"#\">000-000000-00-000</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">ACCOUNT HOLDER:     </a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-xl-3 col-lg-3 col-md-5 col-sm-7\">\r\n");
      out.write("                        <div class=\"single-footer-caption mb-50\">\r\n");
      out.write("                            <div class=\"footer-tittle\">\r\n");
      out.write("                            <P align=\"center\">  \r\n");
      out.write("                            <br>\r\n");
      out.write("                            <br>\r\n");
      out.write("                                <h4>SUPPORT</h4>\r\n");
      out.write("                                <ul>\r\n");
      out.write("                                    <li><a href=\"#\">Frequently Asked Questions</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">Privacy Policy</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">Report a Payment Issue</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- Footer bottom -->\r\n");
      out.write("                <div class=\"row align-items-center\">\r\n");
      out.write("                    <div class=\"col-xl-7 col-lg-8 col-md-7\">\r\n");
      out.write("                        <div class=\"footer-copy-right\">\r\n");
      out.write("                            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\r\n");
      out.write("  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | <i class=\"fa fa-heart\" aria-hidden=\"true\"></i> by <a href=\"https://colorlib.com\" target=\"_blank\">Colorlib</a>\r\n");
      out.write("  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>               \r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-xl-5 col-lg-4 col-md-5\">\r\n");
      out.write("                        <div class=\"footer-copy-right f-right\">\r\n");
      out.write("                            <!-- social -->\r\n");
      out.write("                            <div class=\"footer-social\">\r\n");
      out.write("                                <a href=\"#\"><i class=\"fab fa-twitter\"></i></a>\r\n");
      out.write("                                <a href=\"https://www.facebook.com\"><i class=\"fab fa-facebook-f\"></i></a>\r\n");
      out.write("                                <a href=\"#\"><i class=\"fab fa-behance\"></i></a>\r\n");
      out.write("                                <a href=\"#\"><i class=\"fas fa-globe\"></i></a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Footer End-->\r\n");
      out.write("    </footer>\r\n");
      out.write("    <!--? Search model Begin -->\r\n");
      out.write("    <div class=\"search-model-box\">\r\n");
      out.write("        <div class=\"h-100 d-flex align-items-center justify-content-center\">\r\n");
      out.write("            <div class=\"search-close-btn\">+</div>\r\n");
      out.write("            <form class=\"search-model-form\">\r\n");
      out.write("                <input type=\"text\" id=\"search-input\" placeholder=\"Searching key.....\">\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
