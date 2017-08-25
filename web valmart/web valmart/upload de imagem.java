protected void processRequest(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        response.setContentType("text/html;charset=UTF-8");  
        try {  
            MultipartRequest multipartRequest = new MultipartRequest(request, getServletContext().getRealPath("/APPS/adm/upload/tmp/"), /* 150MB */ 153600 * 153600, new DefaultFileRenamePolicy());  
            if (multipartRequest.getParameter("save") != null) {  
                upload(request, response, multipartRequest);  
            } else {  
                throw new IOException();  
            }  
        } catch (IOException ex) {  
        }  
  
    }  
  
    private void upload(HttpServletRequest request, HttpServletResponse response, MultipartRequest multipartRequest) throws IOException { //OK  
  
        File tmpFile = multipartRequest.getFile("uploaded"); //esse daqui é o name do input file  
  
        String dado1 = multipartRequest.getParameter("dado1"); //um campo  
        String dado2 = multipartRequest.getParameter("dado2"); //outro campo  
  
        //o resto do teu código  
.  
.  //enctype="multipart/form-data"
.  
    }  