package com.ljmu.educationalphishingtool;

public class QuizContents {

    //Pre-test questions array
    public static String[] preQuestions = new String [] {
            "Is this email from QuickBooks a phishing attempt?",
            "Is this email from Wells Fargo a phishing attempt?",
            "Is this email from Dropbox a phishing attempt?",
            "Is this email from Google a phishing attempt?",
            "Is this verification email from Apple a phishing attempt?",
            "Is this password reset email from Apple a phishing attempt?",
            "Is this email from PayPal a phishing attempt?",
            "Is this email regarding a developer job a phishing attempt?",
            "Is this email from TransUnion a phishing attempt?",
            "Is this email regarding password reset a phishing attempt?",
            "Is this email from American Express a phishing attempt?",
            "Is this email from IT Services a phishing attempt?"

    };

    //Pre-test images array
    public static int[] preImages = new int[] {
            R.drawable.one_real,
            R.drawable.two_phishing,
            R.drawable.three_phishing,
            R.drawable.four_real,
            R.drawable.five_real,
            R.drawable.six_phishing,
            R.drawable.seven_real,
            R.drawable.eight_phishing,
            R.drawable.nine_real,
            R.drawable.ten_phishing,
            R.drawable.eleven_phishing,
            R.drawable.twelve_real
    };

    //Pre-test answers array
    public static boolean[] preAnswers = new boolean[] {
            true,
            false,
            false,
            true,
            true,
            false,
            true,
            false,
            true,
            false,
            false,
            true
    };

    //Post-test questions array
   public static String[] postQuestions = new String [] {
            "Is this email from PayPal a phishing attempt?",
            "Is this email from HubSpot a phishing attempt?",
            "Is this email regarding account suspension a phishing attempt?",
            "Is this email from DHL a phishing attempt?",
            "Is this email from Dropbox a phishing attempt?",
            "Is this email from Wells Fargo a phishing attempt?",
            "Is this email from SendGrid a phishing attempt?",
            "Is this email from Microsoft a phishing attempt?",
            "Is this email from Google a phishing attempt?",
            "Is this email from Jakprints a phishing attempt?",
            "Is this email regarding unsubmitted reports a phishing attempt?",
            "Is this email from TD Bank a phishing attempt?"
    };

    //Post-test images array
    public static int[] postImages = new int[] {
            R.drawable.thirteen_phishing,
            R.drawable.fourteen_real,
            R.drawable.fifteen_phishing,
            R.drawable.sixteen_phishing,
            R.drawable.seventeen_real,
            R.drawable.eighteen_phishing,
            R.drawable.nineteen_real,
            R.drawable.twenty_phishing,
            R.drawable.twentyone_phishing,
            R.drawable.twentytwo_real,
            R.drawable.twentythree_real,
            R.drawable.twentyfour_phishing
    };

    //Post-test answers array
    public static boolean[] postAnswers = new boolean[] {
            false,
            true,
            false,
            false,
            true,
            false,
            true,
            false,
            false,
            true,
            true,
            false
    };
}
