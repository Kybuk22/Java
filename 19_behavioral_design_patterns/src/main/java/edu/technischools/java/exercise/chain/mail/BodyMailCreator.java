/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.exercise.chain.mail;

public class BodyMailCreator extends GenericMailCreator {

  private String body;

  public BodyMailCreator(String body) {
    this.body = body;
  }

  @Override
  protected Mail createPart(Mail mail) {
    mail.setBody(this.body);

    return mail;
  }
}
