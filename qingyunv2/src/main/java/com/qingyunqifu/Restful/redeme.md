###使用Spring MVC来开发Restful Api

##一、写Restfui api的测试用例
`        mvc.perform(MockMvcRequestBuilders.get("/rsellers")
                 .contentType(MediaType.APPLICATION_JSON_UTF8))
                 .andExpect(MockMvcResultMatchers.status().isOk())
                 .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
     }`