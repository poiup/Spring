/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.58
 * Generated at: 2022-04-25 02:44:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class test_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("	* {list-style: none}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h2>\r\n");
      out.write("</h2>\r\n");
      out.write("<ul id=\"replies\">\r\n");
      out.write("</ul>\r\n");
      out.write("\r\n");
      out.write("<ul id=\"test\">\r\n");
      out.write("</ul>\r\n");
      out.write("<button id=\"testBtn\">다음링크 생성</button>\r\n");
      out.write("<button onclick=\"getAllList()\">댓글 불러오기</button>\r\n");
      out.write("<div>\r\n");
      out.write("		<div>\r\n");
      out.write("			REPLYER <input type=\"text\" name=\"replyer\" id=\"newReplyWriter\">\r\n");
      out.write("		</div>\r\n");
      out.write("		<div>\r\n");
      out.write("			REPLY TEXT <input type=\"text\" name=\"reply\" id=\"newReply\">\r\n");
      out.write("		</div>\r\n");
      out.write("		<button id=\"replyAddBtn\" onclick=\"addReply()\">ADD REPLY</button>\r\n");
      out.write("	</div>\r\n");
      out.write("<!--jquery는 여기서  -->\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	\r\n");
      out.write("			var bno = 311353;\r\n");
      out.write("			// 댓글 불러오는 function\r\n");
      out.write("	 function getAllList(){\r\n");
      out.write("						// 주소					// 콜백함수 주소요청으로 얻어온 json을 어떻게 처리할지\r\n");
      out.write("			$.getJSON(\"/replies/all/\" + bno, function(data){\r\n");
      out.write("				//getJSON은 rest컨트롤러에 get방식으로 요청을 넣습니다.\r\n");
      out.write("				// 문자열을 이용해 태그를 생성하거나 끼워넣을수 있으므로\r\n");
      out.write("				// 빈 문자열을 만들어 놓고 거기에 댓글정보를 저장해 화면에 전송\r\n");
      out.write("				var str = \"\";		\r\n");
      out.write("				// 들고온 데이터 반복해서 출력하기\r\n");
      out.write("				// $(JSON형식데이터).each => 내부 JSON을 향상된 for문 형식으로 처리합니다.\r\n");
      out.write("				// 역시 내부에 콜백 함수(로직이 실행되었을떄 추가로 실행할 구문을 정의하기위해 파라미터로 넣는 함수)\r\n");
      out.write("				// 를 이용해 data를 하나하나 향상된 for문형식으로 처리할때 실행구문을 적을 수 있습니다.\r\n");
      out.write("				$(data).each(function(){\r\n");
      out.write("					// 하나하나 반복되는 각 데이터는 this라는 키워드로 표현합니다.\r\n");
      out.write("							str += \"<li data-rno='\" + this.rno + \"' class='replyLi'>\"\r\n");
      out.write("								+ this.rno + \":\" + this.reply\r\n");
      out.write("								+ \"<button>수정/삭제</button><li>\";\r\n");
      out.write("				\r\n");
      out.write("								console.log(\"-------------------------------------\")\r\n");
      out.write("								console.log(this)\r\n");
      out.write("						}); \r\n");
      out.write("					$(\"#replies\").html(str);\r\n");
      out.write("				});\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		function addReply(){\r\n");
      out.write("			var reply = $(\"#newReply\").val();\r\n");
      out.write("			var replyer = $(\"#newReplyWriter\").val();\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				type : 'post',\r\n");
      out.write("				url : '/replies',\r\n");
      out.write("				headers : {\r\n");
      out.write("					\"Content-Type\" : \"application/json\",\r\n");
      out.write("					\"X-HTTP-Method-Override\" : \"POST\"\r\n");
      out.write("				},\r\n");
      out.write("				dataType : 'text',\r\n");
      out.write("				data : JSON.stringify({\r\n");
      out.write("					bno : bno,\r\n");
      out.write("					reply : reply,\r\n");
      out.write("					replyer : replyer\r\n");
      out.write("				}),\r\n");
      out.write("				success : function(result){\r\n");
      out.write("					getAllList();\r\n");
      out.write("					alert(\"등록되었습니다.\");\r\n");
      out.write("					// 글적으면 내부 내용 비우기\r\n");
      out.write("					$(\"#newReply\").val(\"\");\r\n");
      out.write("					$(\"#newReplyWriter\").val(\"\");\r\n");
      out.write("				}\r\n");
      out.write("			})\r\n");
      out.write("		}\r\n");
      out.write("			\r\n");
      out.write("		// 버튼 클릭시 발동되는 이벤트\r\n");
      out.write("					// testBtn클릭시  //함수 실행(45~48)\r\n");
      out.write("		$(\"#testBtn\").on(\"click\", function(){\r\n");
      out.write("			var strTest = \"<a href='https://www.daum.net/'>다음으로 이동</a>\";\r\n");
      out.write("			$(\"#test\").html(strTest);\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("		$(\"#replies\").on(\"click\", \".replyLi button\", function(){\r\n");
      out.write("			// 클릭한 버튼과 연계된 부모태그인 li태그를 replytag변수에 저장합니다.\r\n");
      out.write("			var replytag = $(this).parent();\r\n");
      out.write("			console.log(replytag);\r\n");
      out.write("			var rno = replytag.attr(\"data-rno\");\r\n");
      out.write("			var reply = replytag.text();\r\n");
      out.write("			\r\n");
      out.write("			alert(rno + \"  : \" + reply);\r\n");
      out.write("		})\r\n");
      out.write("	\r\n");
      out.write("</script>\r\n");
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
