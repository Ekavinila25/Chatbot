package org.example.adminrole.controller;

import org.example.adminrole.model.Conversation;

import javax.ws.rs.*;
import java.util.List;

/**
 * Class which give the path and do the specified action.
 */
public class ApiService extends AdminController implements ApiInterface {

    /**
     * using path add the chat.
     *
     * @param question
     * @param answer
     * @return
     */
    @Path("/add")
    @Consumes("application/json")
    @POST()
    public boolean addChat(final String question, final String answer) {
        return super.addChat(question, answer);
    }

    /**
     * using path update the chat.
     *
     * @param id
     * @param question
     * @param answer
     * @return
     */
    @Consumes("application/json")
    @Path("/update")
    @PUT
    public boolean updateChat(final int id, final String question, final String answer) {
        return super.updateChat(id, question, answer);
    }

    /**
     * Using path delete the chat.
     *
     * @param id
     * @return
     */
    @Path("/{id}")
    @DELETE
    public boolean deleteChat(@PathParam("id") final int id) {
        return super.deleteChat(id);
    }

    /**
     * @param page
     * @param limit
     * @return
     */
    @Path("/get")
    @Produces("application/json")
    @GET
    public List<Conversation> viewChat(@QueryParam("page") int page, @DefaultValue("4") @QueryParam("limit") int limit) {
        List<Conversation> list = super.viewChat();
        int start = 0, end = 0;
        if (page > 0 && limit >= 0) {
            start = ((page - 1) * limit);
            end = limit * page;
        }
        if (start < list.size() && end < list.size()) {
            return list.subList(start, end);
        } else if (start < list.size()) {
            return list.subList(start, list.size());
        }
        return null;
    }

}
