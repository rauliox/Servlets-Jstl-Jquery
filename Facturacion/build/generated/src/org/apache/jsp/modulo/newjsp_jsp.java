package org.apache.jsp.modulo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<script type=\"text/javascript\"> \n");
      out.write(" \n");
      out.write("    // unblock when ajax activity stops \n");
      out.write("    $(document).ajaxStop($.unblockUI); \n");
      out.write(" \n");
      out.write("    function test() { \n");
      out.write("        $.ajax({ url: 'wait.php', cache: false }); \n");
      out.write("    } \n");
      out.write(" \n");
      out.write("    $(document).ready(function() { \n");
      out.write("        $('#pageDemo1').click(function() { \n");
      out.write("            $.blockUI(); \n");
      out.write("            test(); \n");
      out.write("        }); \n");
      out.write("        $('#pageDemo2').click(function() { \n");
      out.write("            $.blockUI({ message: '<h1><img src=\"busy.gif\" /> Just a moment...</h1>' }); \n");
      out.write("            test(); \n");
      out.write("        }); \n");
      out.write("        $('#pageDemo3').click(function() { \n");
      out.write("            $.blockUI({ css: { backgroundColor: '#f00', color: '#fff' } }); \n");
      out.write("            test(); \n");
      out.write("        }); \n");
      out.write(" \n");
      out.write("        $('#pageDemo4').click(function() { \n");
      out.write("            $.blockUI({ message: $('#domMessage') }); \n");
      out.write("            test(); \n");
      out.write("        }); \n");
      out.write("    }); \n");
      out.write(" \n");
      out.write("</script> \n");
      out.write(" \n");
      out.write(" <html>\n");
      out.write("     <div id=\"domMessage\" style=\"display:none;\"> \n");
      out.write("    <h1>We are processing your request.  Please be patient.</h1> \n");
      out.write("</div> \n");
      out.write("</html>\n");
      out.write(" \n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
