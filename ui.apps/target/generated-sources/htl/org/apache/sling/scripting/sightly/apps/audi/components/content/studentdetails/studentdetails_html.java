/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.audi.components.content.studentdetails;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class studentdetails_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_model = null;
Collection var_collectionvar0_list_coerced$ = null;
Collection var_collectionvar11_list_coerced$ = null;
Object _dynamic_resource = bindings.get("resource");
Collection var_collectionvar22_list_coerced$ = null;
Collection var_collectionvar33_list_coerced$ = null;
Collection var_collectionvar44_list_coerced$ = null;
Collection var_collectionvar54_list_coerced$ = null;
out.write("<div>student details</div>\n\n");
_global_model = renderContext.call("use", com.moonraft.core.models.StudentDetailsImpl.class.getName(), obj());
out.write("<div>\n    <p>Model -Student Details</p>\n    ");
{
    Object var_collectionvar0 = renderContext.getObjectModel().resolveProperty(_global_model, "studentDetailsWithMap");
    {
        long var_size1 = ((var_collectionvar0_list_coerced$ == null ? (var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0)) : var_collectionvar0_list_coerced$).size());
        {
            boolean var_notempty2 = (var_size1 > 0);
            if (var_notempty2) {
                {
                    long var_end5 = var_size1;
                    {
                        boolean var_validstartstepend6 = (((0 < var_size1) && true) && (var_end5 > 0));
                        if (var_validstartstepend6) {
                            out.write("<ul>");
                            if (var_collectionvar0_list_coerced$ == null) {
                                var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0);
                            }
                            long var_index7 = 0;
                            for (Object a : var_collectionvar0_list_coerced$) {
                                {
                                    boolean var_traversal9 = (((var_index7 >= 0) && (var_index7 <= var_end5)) && true);
                                    if (var_traversal9) {
                                        out.write("\n        <li>");
                                        {
                                            String var_10 = ("Name: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(a, "studentname"), "text")));
                                            out.write(renderContext.getObjectModel().toString(var_10));
                                        }
                                        out.write("</li>\n        <li>Phone Numbers:\n            ");
                                        {
                                            Object var_collectionvar11 = renderContext.getObjectModel().resolveProperty(a, "phone");
                                            {
                                                long var_size12 = ((var_collectionvar11_list_coerced$ == null ? (var_collectionvar11_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar11)) : var_collectionvar11_list_coerced$).size());
                                                {
                                                    boolean var_notempty13 = (var_size12 > 0);
                                                    if (var_notempty13) {
                                                        {
                                                            long var_end16 = var_size12;
                                                            {
                                                                boolean var_validstartstepend17 = (((0 < var_size12) && true) && (var_end16 > 0));
                                                                if (var_validstartstepend17) {
                                                                    out.write("<ul>");
                                                                    if (var_collectionvar11_list_coerced$ == null) {
                                                                        var_collectionvar11_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar11);
                                                                    }
                                                                    long var_index18 = 0;
                                                                    for (Object b : var_collectionvar11_list_coerced$) {
                                                                        {
                                                                            boolean var_traversal20 = (((var_index18 >= 0) && (var_index18 <= var_end16)) && true);
                                                                            if (var_traversal20) {
                                                                                out.write("\n                <li>");
                                                                                {
                                                                                    String var_21 = ("Phone numbers: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(b, "phonenumber"), "text")));
                                                                                    out.write(renderContext.getObjectModel().toString(var_21));
                                                                                }
                                                                                out.write("</li>\n            ");
                                                                            }
                                                                        }
                                                                        var_index18++;
                                                                    }
                                                                    out.write("</ul>");
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            var_collectionvar11_list_coerced$ = null;
                                        }
                                        out.write("\n        </li>\n    ");
                                    }
                                }
                                var_index7++;
                            }
                            out.write("</ul>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar0_list_coerced$ = null;
}
out.write("\n</div>\n\n");
{
    Object var_collectionvar22 = renderContext.getObjectModel().resolveProperty(_dynamic_resource, "getChildren");
    {
        long var_size23 = ((var_collectionvar22_list_coerced$ == null ? (var_collectionvar22_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar22)) : var_collectionvar22_list_coerced$).size());
        {
            boolean var_notempty24 = (var_size23 > 0);
            if (var_notempty24) {
                {
                    long var_end27 = var_size23;
                    {
                        boolean var_validstartstepend28 = (((0 < var_size23) && true) && (var_end27 > 0));
                        if (var_validstartstepend28) {
                            out.write("<div>");
                            if (var_collectionvar22_list_coerced$ == null) {
                                var_collectionvar22_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar22);
                            }
                            long var_index29 = 0;
                            for (Object swm : var_collectionvar22_list_coerced$) {
                                {
                                    boolean var_traversal31 = (((var_index29 >= 0) && (var_index29 <= var_end27)) && true);
                                    if (var_traversal31) {
                                        out.write("\n  ");
                                        {
                                            boolean var_testvariable32 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(swm, "name"), "studentdetailswithmap"));
                                            if (var_testvariable32) {
                                                out.write("<div>\n        <p>Htl - StudentDetails</p>\n      ");
                                                {
                                                    Object var_collectionvar33 = renderContext.getObjectModel().resolveProperty(swm, "getChildren");
                                                    {
                                                        long var_size34 = ((var_collectionvar33_list_coerced$ == null ? (var_collectionvar33_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar33)) : var_collectionvar33_list_coerced$).size());
                                                        {
                                                            boolean var_notempty35 = (var_size34 > 0);
                                                            if (var_notempty35) {
                                                                {
                                                                    long var_end38 = var_size34;
                                                                    {
                                                                        boolean var_validstartstepend39 = (((0 < var_size34) && true) && (var_end38 > 0));
                                                                        if (var_validstartstepend39) {
                                                                            out.write("<ul>");
                                                                            if (var_collectionvar33_list_coerced$ == null) {
                                                                                var_collectionvar33_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar33);
                                                                            }
                                                                            long var_index40 = 0;
                                                                            for (Object a : var_collectionvar33_list_coerced$) {
                                                                                {
                                                                                    boolean var_traversal42 = (((var_index40 >= 0) && (var_index40 <= var_end38)) && true);
                                                                                    if (var_traversal42) {
                                                                                        out.write("\n         <li>");
                                                                                        {
                                                                                            String var_43 = ("Name: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(a, "studentname"), "text")));
                                                                                            out.write(renderContext.getObjectModel().toString(var_43));
                                                                                        }
                                                                                        out.write("</li>\n         <li>Phone:\n             ");
                                                                                        {
                                                                                            Object var_collectionvar44 = renderContext.getObjectModel().resolveProperty(a, "getChildren");
                                                                                            {
                                                                                                long var_size45 = ((var_collectionvar44_list_coerced$ == null ? (var_collectionvar44_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar44)) : var_collectionvar44_list_coerced$).size());
                                                                                                {
                                                                                                    boolean var_notempty46 = (var_size45 > 0);
                                                                                                    if (var_notempty46) {
                                                                                                        {
                                                                                                            long var_end49 = var_size45;
                                                                                                            {
                                                                                                                boolean var_validstartstepend50 = (((0 < var_size45) && true) && (var_end49 > 0));
                                                                                                                if (var_validstartstepend50) {
                                                                                                                    out.write("<div>");
                                                                                                                    if (var_collectionvar44_list_coerced$ == null) {
                                                                                                                        var_collectionvar44_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar44);
                                                                                                                    }
                                                                                                                    long var_index51 = 0;
                                                                                                                    for (Object swm_1 : var_collectionvar44_list_coerced$) {
                                                                                                                        {
                                                                                                                            boolean var_traversal53 = (((var_index51 >= 0) && (var_index51 <= var_end49)) && true);
                                                                                                                            if (var_traversal53) {
                                                                                                                                out.write("\n              ");
                                                                                                                                {
                                                                                                                                    boolean var_testvariable61 = (org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(swm_1, "name"), "phone"));
                                                                                                                                    if (var_testvariable61) {
                                                                                                                                        {
                                                                                                                                            Object var_collectionvar54 = renderContext.getObjectModel().resolveProperty(swm_1, "getChildren");
                                                                                                                                            {
                                                                                                                                                long var_size55 = ((var_collectionvar54_list_coerced$ == null ? (var_collectionvar54_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar54)) : var_collectionvar54_list_coerced$).size());
                                                                                                                                                {
                                                                                                                                                    boolean var_notempty56 = (var_size55 > 0);
                                                                                                                                                    if (var_notempty56) {
                                                                                                                                                        {
                                                                                                                                                            long var_end59 = var_size55;
                                                                                                                                                            {
                                                                                                                                                                boolean var_validstartstepend60 = (((0 < var_size55) && true) && (var_end59 > 0));
                                                                                                                                                                if (var_validstartstepend60) {
                                                                                                                                                                    out.write("<ul>");
                                                                                                                                                                    if (var_collectionvar54_list_coerced$ == null) {
                                                                                                                                                                        var_collectionvar54_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar54);
                                                                                                                                                                    }
                                                                                                                                                                    long var_index62 = 0;
                                                                                                                                                                    for (Object b : var_collectionvar54_list_coerced$) {
                                                                                                                                                                        {
                                                                                                                                                                            boolean var_traversal64 = (((var_index62 >= 0) && (var_index62 <= var_end59)) && true);
                                                                                                                                                                            if (var_traversal64) {
                                                                                                                                                                                out.write("\n                    <li>");
                                                                                                                                                                                {
                                                                                                                                                                                    String var_65 = ("Phone Number: " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(b, "phonenumber"), "text")));
                                                                                                                                                                                    out.write(renderContext.getObjectModel().toString(var_65));
                                                                                                                                                                                }
                                                                                                                                                                                out.write("</li>\n               ");
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                        var_index62++;
                                                                                                                                                                    }
                                                                                                                                                                    out.write("</ul>");
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            var_collectionvar54_list_coerced$ = null;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                out.write("\n             ");
                                                                                                                            }
                                                                                                                        }
                                                                                                                        var_index51++;
                                                                                                                    }
                                                                                                                    out.write("</div>");
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            var_collectionvar44_list_coerced$ = null;
                                                                                        }
                                                                                        out.write("\n         </li>\n      ");
                                                                                    }
                                                                                }
                                                                                var_index40++;
                                                                            }
                                                                            out.write("</ul>");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    var_collectionvar33_list_coerced$ = null;
                                                }
                                                out.write("\n  </div>");
                                            }
                                        }
                                        out.write("\n");
                                    }
                                }
                                var_index29++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar22_list_coerced$ = null;
}
out.write("\n\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

