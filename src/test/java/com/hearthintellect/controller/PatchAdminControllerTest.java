package com.hearthintellect.controller;

import com.hearthintellect.model.Patch;
import com.hearthintellect.model.Token;
import com.hearthintellect.util.ResourceUtils;
import com.hearthintellect.utils.LocaleString;
import com.hearthintellect.utils.Message;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Locale;

public class PatchAdminControllerTest extends ControllerTest {

    private Patch newPatch;

    @Before
    public void setUp() {
        super.setUp();
        newPatch = ResourceUtils.readResrouceJsonAsEntity("new_patch.json", Patch.class, gson);
    }

    @Test
    @Ignore
    public void testCreatingPatchWithoutToken() {
        postWithAssertion("/patches", newPatch, 401, emptyTokenMessage());
    }

    @Test
    @Ignore
    public void testCreatingPatchWithNonAdminToken() {
        Token testToken = testTokens.get(0);
        Message expectedMessage = invalidTokenMessage(testToken.getID());
        postWithAssertion("/patches?token=" + testToken.getID(), newPatch, 401, expectedMessage);
    }

    @Test
    @Ignore
    public void testCreatingExistedPatch() {
        Patch testPatch = testPatches.get(0);
        Message expectedMessage = duplicateEntityMessage("Patch", testPatch.getID());
        postWithAssertion("/patches?token=" + adminTokenID, testPatch, 403, expectedMessage);
    }

    @Test
    @Ignore
    public void testCreatingNonExistedPatch() {
        Message expectedMessage = entityCreatedMessage("Patch", newPatch.getID(), "/patches/" + newPatch.getID());
        postWithAssertion("/patches?token=" + adminTokenID, newPatch, 201, expectedMessage);
        getWithAssertion("/patches/" + newPatch.getID(), 200, newPatch);
    }

    @Test
    @Ignore
    public void testDeletingPatchWithoutToken() {
        Patch testPatch = testPatches.get(0);
        deleteWithAssertion("/patches/" + testPatch.getID(), 401, emptyTokenMessage());
    }

    @Test
    @Ignore
    public void testDeletingPatchWithNonAdminToken() {
        Patch testPatch = testPatches.get(0);
        Token testToken = testTokens.get(0);
        Message expectedMessage = invalidTokenMessage(testToken.getID());
        deleteWithAssertion("/patches/" + testPatch.getID() + "?token=" + testToken.getID(), 401, expectedMessage);
    }

    @Test
    @Ignore
    public void testDeletingNonExistedPatch() {
        Message expectedMessage = entityNotFoundMessage("Patch", newPatch.getID());
        deleteWithAssertion("/patches/" + newPatch.getID() + "?token=" + adminTokenID, 404, expectedMessage);
    }

    @Test
    @Ignore
    public void testDeletingExistedPatch() {
        Patch testPatch = testPatches.get(0);
        Message expectedMessage = entityDeletedMessage("Patch", testPatch.getID());
        deleteWithAssertion("/patches/" + testPatch.getID() + "?token=" + adminTokenID, 204, expectedMessage);
        getWithAssertion("/patches/" + testPatch.getID(), 404, null);
    }

    @Test
    @Ignore
    public void testUpdatingPatchWithoutToken() {
        Patch testPatch = testPatches.get(0);
        putWithAssertion("/patches/" + testPatch.getID(), testPatch, 401, emptyTokenMessage());
    }

    @Test
    @Ignore
    public void testUpdatingPatchWithNonAdminToken() {
        Patch testPatch = testPatches.get(0);
        Token testToken = testTokens.get(0);
        Message expectedMessage = invalidTokenMessage(testToken.getID());
        putWithAssertion("/patches/" + testPatch.getID() + "?token=" + testToken.getID(), testPatch, 401, expectedMessage);
    }

    @Test
    @Ignore
    public void testUpdatingNonExistedPatch() {
        Message expectedMessage = entityNotFoundMessage("Patch", newPatch.getID());
        putWithAssertion("/patches/" + newPatch.getID() + "?token=" + adminTokenID, newPatch, 404, expectedMessage);
    }

    @Test
    @Ignore
    public void testUpdatingExistedPatch() {
        Patch testPatch = testPatches.get(0);
        Patch sentPatchBody = new Patch();
        sentPatchBody.setID(testPatch.getID());
        sentPatchBody.setReleaseNote(new LocaleString());
        sentPatchBody.getReleaseNote().put(Locale.US, "Something strange.");
        testPatch.getReleaseNote().put(Locale.US, "Something strange.");
        sentPatchBody.getReleaseNote().put(Locale.CHINA, "");
        testPatch.getReleaseNote().put(Locale.CHINA, "");

        Message expectedMessage = entityUpdatedMessage("Patch", testPatch.getID(), "/patches/" + testPatch.getID());
        putWithAssertion("/patches/" + testPatch.getID() + "?token=" + adminTokenID, newPatch, 201, expectedMessage);
        getWithAssertion("/patches/" + testPatch.getID(), 200, testPatch);
    }
}
