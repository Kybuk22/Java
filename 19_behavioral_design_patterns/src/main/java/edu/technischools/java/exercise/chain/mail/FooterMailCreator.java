/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.exercise.chain.mail;

public class FooterMailCreator extends GenericMailCreator {

  private String footer;

  public FooterMailCreator(String footer) {
    this.footer = footer;
  }

  @Override
  protected Mail createPart(Mail mail) {
    mail.setFooter(this.footer);

    return mail;
  }
}
