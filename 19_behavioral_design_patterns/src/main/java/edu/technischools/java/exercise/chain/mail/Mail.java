/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.exercise.chain.mail;

import java.util.ArrayList;
import java.util.List;

public class Mail {

  private String header;
  private String body;
  private String footer;
  private List<String> attachments = new ArrayList<>();

  public String getHeader() {
    return header;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getFooter() {
    return footer;
  }

  public void setFooter(String footer) {
    this.footer = footer;
  }

  public List<String> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<String> attachments) {
    this.attachments = attachments;
  }

  @Override
  public String toString() {
    return "Mail{" +
        "header='" + header + '\'' +
        ", body='" + body + '\'' +
        ", footer='" + footer + '\'' +
        ", attachments='" + attachments + '\'' +

        '}';
  }
}
